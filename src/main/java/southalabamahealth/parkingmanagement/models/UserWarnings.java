package southalabamahealth.parkingmanagement.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserWarnings
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-18T16:13:02.045Z[GMT]")


public class UserWarnings   {
  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("directSupervisor")
  private String directSupervisor = null;

  @JsonProperty("comments")
  private String comments = null;

  @JsonProperty("file")
  @Valid
  private List<Resource> file = new ArrayList<Resource>();

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  public UserWarnings userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public UserWarnings id(Long id) {
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

  public UserWarnings location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public UserWarnings directSupervisor(String directSupervisor) {
    this.directSupervisor = directSupervisor;
    return this;
  }

  /**
   * Get directSupervisor
   * @return directSupervisor
   **/
  @Schema(description = "")
  
    public String getDirectSupervisor() {
    return directSupervisor;
  }

  public void setDirectSupervisor(String directSupervisor) {
    this.directSupervisor = directSupervisor;
  }

  public UserWarnings comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Get comments
   * @return comments
   **/
  @Schema(description = "")
  
    public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public UserWarnings file(List<Resource> file) {
    this.file = file;
    return this;
  }

  public UserWarnings addFileItem(Resource fileItem) {
    this.file.add(fileItem);
    return this;
  }

  /**
   * Get file
   * @return file
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Resource> getFile() {
    return file;
  }

  public void setFile(List<Resource> file) {
    this.file = file;
  }

  public UserWarnings createDate(OffsetDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * Get createDate
   * @return createDate
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(OffsetDateTime createDate) {
    this.createDate = createDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserWarnings userWarnings = (UserWarnings) o;
    return Objects.equals(this.userId, userWarnings.userId) &&
        Objects.equals(this.id, userWarnings.id) &&
        Objects.equals(this.location, userWarnings.location) &&
        Objects.equals(this.directSupervisor, userWarnings.directSupervisor) &&
        Objects.equals(this.comments, userWarnings.comments) &&
        Objects.equals(this.file, userWarnings.file) &&
        Objects.equals(this.createDate, userWarnings.createDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, id, location, directSupervisor, comments, file, createDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserWarnings {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    directSupervisor: ").append(toIndentedString(directSupervisor)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
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
