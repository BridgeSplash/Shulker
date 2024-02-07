use super::{http_credentials::HttpCredentials, ResourceRefError, Result};

#[derive(Clone, Debug, PartialEq)]
pub struct MavenArtifact {
    repository_url: String,
    group_id: String,
    artifact_id: String,
    version: String,
    snapshot_version: Option<String>,
    classifier: Option<String>,
    credentials: Option<HttpCredentials>,
}

#[derive(Clone, Debug, PartialEq)]
pub enum ResourceRef {
    Url(String),
    MavenArtifact {
        repository_url: String,
        group_id: String,
        artifact_id: String,
        version: String,
        snapshot_version: Option<String>,
        classifier: Option<String>,
        credentials: Option<HttpCredentials>,
    },
    GithubRelease {
        repository_url: String,
        artifact_id: String,
        version: String,
        classifier: Option<String>,
    },
}

impl ResourceRef {
    pub fn as_url(&self) -> Result<url::Url> {
        match self {
            ResourceRef::Url(url) => {
                Ok(url::Url::parse(url).map_err(ResourceRefError::InvalidUrlSpec)?)
            }
            ResourceRef::MavenArtifact {
                repository_url,
                group_id,
                artifact_id,
                version,
                snapshot_version,
                classifier,
                credentials,
            } => {
                let group_path = group_id.replace('.', "/");
                let file_version = snapshot_version.as_ref().unwrap_or(version);
                let file_name = match classifier {
                    None => format!("{}-{}.jar", artifact_id, file_version),
                    Some(classifier) => {
                        format!("{}-{}-{}.jar", artifact_id, file_version, classifier)
                    }
                };

                let mut url = url::Url::parse(&format!(
                    "{}/{}/{}/{}/{}",
                    repository_url, group_path, artifact_id, version, file_name
                ))
                .map_err(ResourceRefError::InvalidUrlSpec)?;

                if let Some(credentials) = &credentials {
                    url.set_username(&credentials.username).unwrap();
                    url.set_password(Some(&credentials.password)).unwrap();
                }

                Ok(url)
            }
            ResourceRef::GithubRelease {
                repository_url,
                artifact_id,
                version,
                classifier,
            } => {
                let github_url = "https://github.com/";
                let repository_url = repository_url.strip_prefix(github_url).unwrap_or(repository_url);

                let file_name = match classifier {
                    None => format!("{}-{}.jar", artifact_id, classifier.as_ref().unwrap_or(&version)),
                    Some(classifier) => {
                        format!("{}-{}-{}.jar", artifact_id, version, classifier)
                    }
                };

                println!("{}  -   {}", github_url, repository_url);

                let output_url_string = &format!(
                    "{}{}/releases/download/{}-{}/{}",
                    github_url, repository_url, version, artifact_id, file_name
                );

                println!("{}", output_url_string);

                let url = url::Url::parse(output_url_string)
                .map_err(ResourceRefError::InvalidUrlSpec)?;

                Ok(url)
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::resources::http_credentials::HttpCredentials;

    #[test]
    fn serialize_url() {
        // G
        let resourceref = super::ResourceRef::Url("https://example.com/myfile.tar.gz".to_string());

        // W
        let url = resourceref.as_url().unwrap();

        // T
        assert_eq!(url.to_string(), "https://example.com/myfile.tar.gz");
    }

    #[test]
    fn serialize_github_release() {
        let resourceref = super::ResourceRef::GithubRelease {
            repository_url: "bridgesplash/Shulker".to_string(),
            artifact_id: "shulker-server-agent".to_string(),
            version: "1.1.6".to_string(),
            classifier: Some("minestom".to_string()),
        };

        let url = resourceref.as_url().unwrap();

        assert_eq!(
            url.to_string(),
            "https://github.com/bridgesplash/Shulker/releases/download/1.1.6-shulker-server-agent/shulker-server-agent-1.1.6-minestom.jar"
        );
    }

    #[test]
    fn serialize_github_release_with_github_prefix(){
        let resourceref = super::ResourceRef::GithubRelease {
            repository_url: "https://github.com/bridgesplash/Shulker".to_string(),
            artifact_id: "shulker-server-agent".to_string(),
            version: "1.1.6".to_string(),
            classifier: Some("minestom".to_string()),
        };

        let url = resourceref.as_url().unwrap();

        assert_eq!(
            url.to_string(),
            "https://github.com/bridgesplash/Shulker/releases/download/1.1.6-shulker-server-agent/shulker-server-agent-1.1.6-minestom.jar"
        );
    }

    #[test]
    fn serialize_mavenartifact_with_snapshot_version() {
        // G
        let resourceref = super::ResourceRef::MavenArtifact {
            repository_url: "https://example.com".to_string(),
            group_id: "io.shulkermc".to_string(),
            artifact_id: "test".to_string(),
            version: "1.0.0".to_string(),
            snapshot_version: Some("0.3.0-20231127.101010-1".to_string()),
            classifier: None,
            credentials: None,
        };

        // W
        let url = resourceref.as_url().unwrap();

        // T
        assert_eq!(
            url.to_string(),
            "https://example.com/io/shulkermc/test/1.0.0/test-0.3.0-20231127.101010-1.jar"
        );
    }

    #[test]
    fn serialize_mavenartifact_with_classifier() {
        // G
        let resourceref = super::ResourceRef::MavenArtifact {
            repository_url: "https://example.com".to_string(),
            group_id: "io.shulkermc".to_string(),
            artifact_id: "test".to_string(),
            version: "1.0.0".to_string(),
            snapshot_version: None,
            classifier: Some("api".to_string()),
            credentials: None,
        };

        // W
        let url = resourceref.as_url().unwrap();

        // T
        assert_eq!(
            url.to_string(),
            "https://example.com/io/shulkermc/test/1.0.0/test-1.0.0-api.jar"
        );
    }

    #[test]
    fn serialize_mavenartifact_with_credentials() {
        // G
        let resourceref = super::ResourceRef::MavenArtifact {
            repository_url: "https://example.com".to_string(),
            group_id: "io.shulkermc".to_string(),
            artifact_id: "test".to_string(),
            version: "1.0.0".to_string(),
            snapshot_version: None,
            classifier: Some("api".to_string()),
            credentials: Some(HttpCredentials {
                username: "user".to_string(),
                password: "pass".to_string(),
            }),
        };

        // W
        let url = resourceref.as_url().unwrap();

        // T
        assert_eq!(
            url.to_string(),
            "https://user:pass@example.com/io/shulkermc/test/1.0.0/test-1.0.0-api.jar"
        );
    }
}
