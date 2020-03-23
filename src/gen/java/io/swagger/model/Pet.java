/*
 * Swagger Petstore
 * A sample API that uses a petstore as an example to demonstrate features in the OpenAPI 3.0 specification
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NewPet;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

/**
 * Pet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-03-18T02:10:00.755Z[GMT]")public class Pet extends NewPet  {
  @JsonProperty("id")
  private Long id = null;

  public Pet id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @Schema(required = true, description = "")
  @NotNull
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return Objects.equals(this.id, pet.id) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
