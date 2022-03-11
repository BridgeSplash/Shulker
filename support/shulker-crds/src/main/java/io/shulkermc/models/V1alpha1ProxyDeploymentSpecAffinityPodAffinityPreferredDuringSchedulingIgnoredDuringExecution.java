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
import io.shulkermc.models.V1alpha1ProxyDeploymentSpecAffinityPodAffinityPodAffinityTerm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)
 */
@ApiModel(description = "The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-11T15:15:23.550Z[Etc/UTC]")
public class V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution {
  public static final String SERIALIZED_NAME_POD_AFFINITY_TERM = "podAffinityTerm";
  @SerializedName(SERIALIZED_NAME_POD_AFFINITY_TERM)
  private V1alpha1ProxyDeploymentSpecAffinityPodAffinityPodAffinityTerm podAffinityTerm;

  public static final String SERIALIZED_NAME_WEIGHT = "weight";
  @SerializedName(SERIALIZED_NAME_WEIGHT)
  private Integer weight;


  public V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution podAffinityTerm(V1alpha1ProxyDeploymentSpecAffinityPodAffinityPodAffinityTerm podAffinityTerm) {
    
    this.podAffinityTerm = podAffinityTerm;
    return this;
  }

   /**
   * Get podAffinityTerm
   * @return podAffinityTerm
  **/
  @ApiModelProperty(required = true, value = "")

  public V1alpha1ProxyDeploymentSpecAffinityPodAffinityPodAffinityTerm getPodAffinityTerm() {
    return podAffinityTerm;
  }


  public void setPodAffinityTerm(V1alpha1ProxyDeploymentSpecAffinityPodAffinityPodAffinityTerm podAffinityTerm) {
    this.podAffinityTerm = podAffinityTerm;
  }


  public V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution weight(Integer weight) {
    
    this.weight = weight;
    return this;
  }

   /**
   * weight associated with matching the corresponding podAffinityTerm, in the range 1-100.
   * @return weight
  **/
  @ApiModelProperty(required = true, value = "weight associated with matching the corresponding podAffinityTerm, in the range 1-100.")

  public Integer getWeight() {
    return weight;
  }


  public void setWeight(Integer weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution v1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution = (V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution) o;
    return Objects.equals(this.podAffinityTerm, v1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution.podAffinityTerm) &&
        Objects.equals(this.weight, v1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(podAffinityTerm, weight);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1ProxyDeploymentSpecAffinityPodAffinityPreferredDuringSchedulingIgnoredDuringExecution {\n");
    sb.append("    podAffinityTerm: ").append(toIndentedString(podAffinityTerm)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

