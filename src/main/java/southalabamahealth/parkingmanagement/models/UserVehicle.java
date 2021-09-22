package southalabamahealth.parkingmanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class UserVehicle implements Serializable {

    @JsonProperty( "plateId")
    @NotNull
    private String plateId;

    @JsonProperty( "plateState")
    @NotNull
    private String plateState;

    @NotNull
    @JsonProperty( "vehicleMake")
    private String vehicleMake;

    @JsonProperty( "vehicleModle")
    @NotNull
    private String vehicleModle;

    @JsonProperty( "vehicleColor")
    @NotNull
    private String vehicleColor;

    @JsonProperty( "userId")
    @NotNull
    private String userId;


}
