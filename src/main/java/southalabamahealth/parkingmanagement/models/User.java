package southalabamahealth.parkingmanagement.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-18T16:13:02.045Z[GMT]")


public class User   {
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

  @JsonProperty("warnings")
  @Valid
  private List<UserWarnings> warnings = null;

  public User id(Long id) {
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

  public User firstName(String firstName) {
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

  public User middleName(String middleName) {
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

  public User lastName(String lastName) {
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

  public User contactNumber(String contactNumber) {
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

  public User department(String department) {
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

  public User supervisor(String supervisor) {
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

  public User email(String email) {
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

  public User driverType(String driverType) {
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

  public User warnings(List<UserWarnings> warnings) {
    this.warnings = warnings;
    return this;
  }

  public User addWarningsItem(UserWarnings warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<UserWarnings>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * Get warnings
   * @return warnings
   **/
  @Schema(description = "")
      @Valid
    public List<UserWarnings> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<UserWarnings> warnings) {
    this.warnings = warnings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.middleName, user.middleName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.contactNumber, user.contactNumber) &&
        Objects.equals(this.department, user.department) &&
        Objects.equals(this.supervisor, user.supervisor) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.driverType, user.driverType) &&
        Objects.equals(this.warnings, user.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, contactNumber, department, supervisor, email, driverType, warnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    supervisor: ").append(toIndentedString(supervisor)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    driverType: ").append(toIndentedString(driverType)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
