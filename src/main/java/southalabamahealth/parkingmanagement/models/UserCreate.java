package southalabamahealth.parkingmanagement.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserCreate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-18T16:13:02.045Z[GMT]")


public class UserCreate   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("MiddleName")
  private String middleName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("contactNumber")
  private String contactNumber = null;

  @JsonProperty("department")
  private String department = null;

  @JsonProperty("supervisor")
  private String supervisor = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("driverType")
  private String driverType = null;

  public UserCreate id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserCreate firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(description = "")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserCreate middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Get middleName
   * @return middleName
   **/
  @Schema(description = "")
  
    public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public UserCreate lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(description = "")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserCreate contactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Get contactNumber
   * @return contactNumber
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public UserCreate department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
   **/
  @Schema(description = "")
  
    public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public UserCreate supervisor(String supervisor) {
    this.supervisor = supervisor;
    return this;
  }

  /**
   * Get supervisor
   * @return supervisor
   **/
  @Schema(description = "")
  
    public String getSupervisor() {
    return supervisor;
  }

  public void setSupervisor(String supervisor) {
    this.supervisor = supervisor;
  }

  public UserCreate email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserCreate driverType(String driverType) {
    this.driverType = driverType;
    return this;
  }

  /**
   * Get driverType
   * @return driverType
   **/
  @Schema(description = "")
  
    public String getDriverType() {
    return driverType;
  }

  public void setDriverType(String driverType) {
    this.driverType = driverType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCreate userCreate = (UserCreate) o;
    return Objects.equals(this.id, userCreate.id) &&
        Objects.equals(this.firstName, userCreate.firstName) &&
        Objects.equals(this.middleName, userCreate.middleName) &&
        Objects.equals(this.lastName, userCreate.lastName) &&
        Objects.equals(this.contactNumber, userCreate.contactNumber) &&
        Objects.equals(this.department, userCreate.department) &&
        Objects.equals(this.supervisor, userCreate.supervisor) &&
        Objects.equals(this.email, userCreate.email) &&
        Objects.equals(this.driverType, userCreate.driverType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, contactNumber, department, supervisor, email, driverType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCreate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    supervisor: ").append(toIndentedString(supervisor)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    driverType: ").append(toIndentedString(driverType)).append("\n");
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
