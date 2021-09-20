package southalabamahealth.parkingmanagement.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "parking-management.parking_user_table")
@Data
public final  class UserDetails  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME",length = 45, nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 45)
    private String middleName;

    @Column(name = "LAST_NAME", length = 45,nullable = false)
    private String lastName;

    @Column(name = "CONTACT_NUMBER",nullable = false)
    private String contactNumber;

    @Column(name = "DEPARTMENT", length = 45,nullable = false)
    private String department;

    @Column(name = "DIRECT_SUPERVISOR", length = 45)
    private String directSupervisor;

    @Column(name = "EMAIL_ADDRESS", length = 45,nullable = false)
    private String emailID;

    @Column(name = "DRIVER_TYPE", length = 45,nullable = false)
    private String driverType;

    @Column(name = "CREATE_DATE", length = 45,nullable = false)
   // @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    private ZonedDateTime createDate;

    @Column(name = "UPDATE_DATE", length = 45,nullable = false)
   //@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    private ZonedDateTime  updateDate;

/*    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<UserWarnings> userWarnings;*/




}
