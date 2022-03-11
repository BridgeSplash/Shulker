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
import java.time.OffsetDateTime;

/**
 * Condition contains details for one aspect of the current state of this API Resource. --- This struct is intended for direct use as an array at the field path .status.conditions.  For example, type FooStatus struct{ // Represents the observations of a foo&#39;s current state. // Known .status.conditions.type are: \&quot;Available\&quot;, \&quot;Progressing\&quot;, and \&quot;Degraded\&quot; // +patchMergeKey&#x3D;type // +patchStrategy&#x3D;merge // +listType&#x3D;map // +listMapKey&#x3D;type Conditions []metav1.Condition &#x60;json:\&quot;conditions,omitempty\&quot; patchStrategy:\&quot;merge\&quot; patchMergeKey:\&quot;type\&quot; protobuf:\&quot;bytes,1,rep,name&#x3D;conditions\&quot;&#x60;   // other fields }
 */
@ApiModel(description = "Condition contains details for one aspect of the current state of this API Resource. --- This struct is intended for direct use as an array at the field path .status.conditions.  For example, type FooStatus struct{ // Represents the observations of a foo's current state. // Known .status.conditions.type are: \"Available\", \"Progressing\", and \"Degraded\" // +patchMergeKey=type // +patchStrategy=merge // +listType=map // +listMapKey=type Conditions []metav1.Condition `json:\"conditions,omitempty\" patchStrategy:\"merge\" patchMergeKey:\"type\" protobuf:\"bytes,1,rep,name=conditions\"`   // other fields }")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-11T15:13:51.331Z[Etc/UTC]")
public class V1alpha1MinecraftServerStatusConditions {
  public static final String SERIALIZED_NAME_LAST_TRANSITION_TIME = "lastTransitionTime";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSITION_TIME)
  private OffsetDateTime lastTransitionTime;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;

  public static final String SERIALIZED_NAME_OBSERVED_GENERATION = "observedGeneration";
  @SerializedName(SERIALIZED_NAME_OBSERVED_GENERATION)
  private Long observedGeneration;

  public static final String SERIALIZED_NAME_REASON = "reason";
  @SerializedName(SERIALIZED_NAME_REASON)
  private String reason;

  /**
   * status of the condition, one of True, False, Unknown.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    TRUE("True"),
    
    FALSE("False"),
    
    UNKNOWN("Unknown");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;


  public V1alpha1MinecraftServerStatusConditions lastTransitionTime(OffsetDateTime lastTransitionTime) {
    
    this.lastTransitionTime = lastTransitionTime;
    return this;
  }

   /**
   * lastTransitionTime is the last time the condition transitioned from one status to another. This should be when the underlying condition changed.  If that is not known, then using the time when the API field changed is acceptable.
   * @return lastTransitionTime
  **/
  @ApiModelProperty(required = true, value = "lastTransitionTime is the last time the condition transitioned from one status to another. This should be when the underlying condition changed.  If that is not known, then using the time when the API field changed is acceptable.")

  public OffsetDateTime getLastTransitionTime() {
    return lastTransitionTime;
  }


  public void setLastTransitionTime(OffsetDateTime lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
  }


  public V1alpha1MinecraftServerStatusConditions message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * message is a human readable message indicating details about the transition. This may be an empty string.
   * @return message
  **/
  @ApiModelProperty(required = true, value = "message is a human readable message indicating details about the transition. This may be an empty string.")

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  public V1alpha1MinecraftServerStatusConditions observedGeneration(Long observedGeneration) {
    
    this.observedGeneration = observedGeneration;
    return this;
  }

   /**
   * observedGeneration represents the .metadata.generation that the condition was set based upon. For instance, if .metadata.generation is currently 12, but the .status.conditions[x].observedGeneration is 9, the condition is out of date with respect to the current state of the instance.
   * minimum: 0
   * @return observedGeneration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "observedGeneration represents the .metadata.generation that the condition was set based upon. For instance, if .metadata.generation is currently 12, but the .status.conditions[x].observedGeneration is 9, the condition is out of date with respect to the current state of the instance.")

  public Long getObservedGeneration() {
    return observedGeneration;
  }


  public void setObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
  }


  public V1alpha1MinecraftServerStatusConditions reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * reason contains a programmatic identifier indicating the reason for the condition&#39;s last transition. Producers of specific condition types may define expected values and meanings for this field, and whether the values are considered a guaranteed API. The value should be a CamelCase string. This field may not be empty.
   * @return reason
  **/
  @ApiModelProperty(required = true, value = "reason contains a programmatic identifier indicating the reason for the condition's last transition. Producers of specific condition types may define expected values and meanings for this field, and whether the values are considered a guaranteed API. The value should be a CamelCase string. This field may not be empty.")

  public String getReason() {
    return reason;
  }


  public void setReason(String reason) {
    this.reason = reason;
  }


  public V1alpha1MinecraftServerStatusConditions status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * status of the condition, one of True, False, Unknown.
   * @return status
  **/
  @ApiModelProperty(required = true, value = "status of the condition, one of True, False, Unknown.")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public V1alpha1MinecraftServerStatusConditions type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * type of condition in CamelCase or in foo.example.com/CamelCase. --- Many .condition.type values are consistent across resources like Available, but because arbitrary conditions can be useful (see .node.status.conditions), the ability to deconflict is important. The regex it matches is (dns1123SubdomainFmt/)?(qualifiedNameFmt)
   * @return type
  **/
  @ApiModelProperty(required = true, value = "type of condition in CamelCase or in foo.example.com/CamelCase. --- Many .condition.type values are consistent across resources like Available, but because arbitrary conditions can be useful (see .node.status.conditions), the ability to deconflict is important. The regex it matches is (dns1123SubdomainFmt/)?(qualifiedNameFmt)")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1MinecraftServerStatusConditions v1alpha1MinecraftServerStatusConditions = (V1alpha1MinecraftServerStatusConditions) o;
    return Objects.equals(this.lastTransitionTime, v1alpha1MinecraftServerStatusConditions.lastTransitionTime) &&
        Objects.equals(this.message, v1alpha1MinecraftServerStatusConditions.message) &&
        Objects.equals(this.observedGeneration, v1alpha1MinecraftServerStatusConditions.observedGeneration) &&
        Objects.equals(this.reason, v1alpha1MinecraftServerStatusConditions.reason) &&
        Objects.equals(this.status, v1alpha1MinecraftServerStatusConditions.status) &&
        Objects.equals(this.type, v1alpha1MinecraftServerStatusConditions.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastTransitionTime, message, observedGeneration, reason, status, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1MinecraftServerStatusConditions {\n");
    sb.append("    lastTransitionTime: ").append(toIndentedString(lastTransitionTime)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    observedGeneration: ").append(toIndentedString(observedGeneration)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

