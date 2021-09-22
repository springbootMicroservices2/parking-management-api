package southalabamahealth.parkingmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.ZonedDateTime;

@Entity
@Table(name = "parking_user_warning")
@Data
public class UserWarnings  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "COMMENTS",length = 45)
    private String comments;

    @Column(name = "DIRECT_SUPERVISOR", length = 45)
    private String directSupervisor;

    @Column(name="IMAGE",nullable = false)
    @Lob
    private byte[] image;


    @Column(name = "CREATE_DATE")
   // @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    private ZonedDateTime createDate;

    @Column(name = "UPDATE_DATE")
    //@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    private ZonedDateTime  updateDate;

    @Column(name="USER_ID",nullable = false)
    private Integer userId;

    @Column(name ="LOCATION")
    private String location = null;
}
