/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.21.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.shulkermc.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Reference to a Minecraft Cluster. Adding this will enroll this Proxy Deployment to be part of a Minecraft Cluster.
 */
@ApiModel(description = "Reference to a Minecraft Cluster. Adding this will enroll this Proxy Deployment to be part of a Minecraft Cluster.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-11T15:15:23.550Z[Etc/UTC]")
public class V1alpha1ProxyDeploymentSpecMinecraftClusterRef {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;


  public V1alpha1ProxyDeploymentSpecMinecraftClusterRef name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of the Minecraft Cluster.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the Minecraft Cluster.")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1ProxyDeploymentSpecMinecraftClusterRef v1alpha1ProxyDeploymentSpecMinecraftClusterRef = (V1alpha1ProxyDeploymentSpecMinecraftClusterRef) o;
    return Objects.equals(this.name, v1alpha1ProxyDeploymentSpecMinecraftClusterRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1ProxyDeploymentSpecMinecraftClusterRef {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

