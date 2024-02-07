use shulker_crds::resourceref::{ResourceRefFromGithubReleaseSpec, ResourceRefFromSpec, ResourceRefSpec};
use url::Url;

use crate::{
    agent::AgentConfig,
    resources::{resourceref_resolver::ResourceRefResolver, ResourceRefError},
};

pub enum AgentSide {
    Proxy,
    Server,
}

impl AgentSide {
    pub fn get_artifact_name(&self) -> &'static str {
        match self {
            AgentSide::Proxy => "shulker-proxy-agent",
            AgentSide::Server => "shulker-server-agent",
        }
    }
}

pub async fn get_agent_plugin_url(
    resourceref_resolver: &ResourceRefResolver,
    agent_config: &AgentConfig,
    side: AgentSide,
    platform: String,
) -> Result<Url, ResourceRefError> {
    resourceref_resolver
        .resolve(
            "shulker-system",
            &ResourceRefSpec {
                url_from: Some(ResourceRefFromSpec {
                    github_release_ref: Some(ResourceRefFromGithubReleaseSpec {
                        repository_url: "bridgesplash/shulker".to_string(),
                        artifact_id: side.get_artifact_name().to_string(),
                        version: agent_config.version.clone(),
                        classifier: Some(platform),
                    }),
                    ..ResourceRefFromSpec::default()
                }),
                ..ResourceRefSpec::default()
            },
        )
        .await?
        .as_url()
}
