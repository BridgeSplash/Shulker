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
 * Configuration of Minecraft Server&#39;s rcon.
 */
@ApiModel(description = "Configuration of Minecraft Server's rcon.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-11T15:13:51.331Z[Etc/UTC]")
public class V1alpha1MinecraftServerSpecRcon {
  public static final String SERIALIZED_NAME_ENABLED = "enabled";
  @SerializedName(SERIALIZED_NAME_ENABLED)
  private Boolean enabled;

  public static final String SERIALIZED_NAME_PASSWORD_SECRET_NAME = "passwordSecretName";
  @SerializedName(SERIALIZED_NAME_PASSWORD_SECRET_NAME)
  private String passwordSecretName;


  public V1alpha1MinecraftServerSpecRcon enabled(Boolean enabled) {
    
    this.enabled = enabled;
    return this;
  }

   /**
   * Whether to enable rcon.
   * @return enabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to enable rcon.")

  public Boolean getEnabled() {
    return enabled;
  }


  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public V1alpha1MinecraftServerSpecRcon passwordSecretName(String passwordSecretName) {
    
    this.passwordSecretName = passwordSecretName;
    return this;
  }

   /**
   * Name of a Kubernetes Secret containing a &#x60;password&#x60; key to use as rcon password. If not provided, a Secret will be created dedicated to this Minecraft Server.
   * @return passwordSecretName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of a Kubernetes Secret containing a `password` key to use as rcon password. If not provided, a Secret will be created dedicated to this Minecraft Server.")

  public String getPasswordSecretName() {
    return passwordSecretName;
  }


  public void setPasswordSecretName(String passwordSecretName) {
    this.passwordSecretName = passwordSecretName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1MinecraftServerSpecRcon v1alpha1MinecraftServerSpecRcon = (V1alpha1MinecraftServerSpecRcon) o;
    return Objects.equals(this.enabled, v1alpha1MinecraftServerSpecRcon.enabled) &&
        Objects.equals(this.passwordSecretName, v1alpha1MinecraftServerSpecRcon.passwordSecretName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, passwordSecretName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1MinecraftServerSpecRcon {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    passwordSecretName: ").append(toIndentedString(passwordSecretName)).append("\n");
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

