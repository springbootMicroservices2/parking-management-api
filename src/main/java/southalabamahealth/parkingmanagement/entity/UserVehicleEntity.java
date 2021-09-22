package southalabamahealth.parkingmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "parking_user_Vehicle_Details")
@Data
public class UserVehicleEntity implements Serializable {

    @Id
    @Column(name="PLATE_ID")
    private String plateId;

    @Column(name = "PLATE_STATE", length = 45,nullable = false)
    private String plateState;

    @Column(name = "VEHICLE_MAKE", length = 45,nullable = false)
    private String vehicleMake;

    @Column(name="VEHICLE_MODEL", length = 45,nullable = false)
    private String vehicleModle;

    @Column(name="VEHICLE_COLOR", length = 45,nullable = false)
    private String vehicleColor;

    @Column(name="USER_ID",nullable = false)
    private Integer userId;


}
