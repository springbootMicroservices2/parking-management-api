package southalabamahealth.parkingmanagement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import southalabamahealth.parkingmanagement.entity.UserDetails;
import southalabamahealth.parkingmanagement.entity.UserVehicleEntity;
import southalabamahealth.parkingmanagement.models.User;
import southalabamahealth.parkingmanagement.models.UserCreate;
import southalabamahealth.parkingmanagement.models.UserVehicle;
import southalabamahealth.parkingmanagement.repository.UserVehicleRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserVehicleApiController {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private UserVehicleRepository userVehicleRepository;

    @Autowired
    public UserVehicleApiController(ObjectMapper objectMapper, HttpServletRequest request, UserVehicleRepository userVehicleRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userVehicleRepository = userVehicleRepository;
    }

    @Operation(summary = "Add user Vehicle details", description = "", tags = {"user-vehicle-api-controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "returns newly created user Vehicle", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserVehicle.class))),

            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "500", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))})
    @RequestMapping(value = "/vehicle",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<UserVehicle> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody UserVehicle body) {
        try {
            UserVehicleEntity entity = new UserVehicleEntity();
            entity.setPlateId(body.getPlateId());
            entity.setVehicleColor(body.getVehicleColor());
            entity.setVehicleMake(body.getVehicleMake());
            entity.setPlateState(body.getPlateState());
            entity.setVehicleModle(body.getVehicleModle());
            entity.setUserId(Integer.parseInt(body.getUserId()));
            userVehicleRepository.saveAndFlush(entity);
            return new ResponseEntity<UserVehicle>(body, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while saving data", e);
            return new ResponseEntity<UserVehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "get user Vehicle details by user Id", description = "", tags = {"user-vehicle-api-controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserVehicle.class)))),

            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "500", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))})
    @RequestMapping(value = "/vehicle/{userId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<UserVehicle>> getVehicleByUserId(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required = true, schema = @Schema()) @PathVariable("userId") String userId) {
        List<UserVehicle> response = new ArrayList<>();
        try {
            if (userId != null) {
                List<UserVehicleEntity> result = userVehicleRepository.findVehicleByUserId();
                if (!result.isEmpty()) {

                    for (UserVehicleEntity entity : result) {
                        UserVehicle body = new UserVehicle();
                        body.setPlateId(entity.getPlateId());
                        body.setVehicleColor(entity.getVehicleColor());
                        body.setVehicleMake(entity.getVehicleMake());
                        body.setPlateState(entity.getPlateState());
                        body.setVehicleModle(entity.getVehicleModle());
                        body.setUserId(String.valueOf(entity.getUserId()));
                        response.add(body);
                    }
                }
            }
            return new ResponseEntity<List<UserVehicle>>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while saving data", e);
            return new ResponseEntity<List<UserVehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "delete  a specific user Vehicle", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserVehicle.class))),

            @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/vehicle/{plateId}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity deleteUserById(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required=true, schema=@Schema()) @PathVariable("plateId") String plateId) {

        try {

            if (plateId != null){
                Optional<UserVehicleEntity> result = userVehicleRepository.findByPlateId(Long.parseLong(plateId));
                result.ifPresent(e -> {
                    userVehicleRepository.deleteByPlateId(Long.parseLong(plateId));
                });
            }else{
                return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error Occurred While Deleting ", e);
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "Update a specific user", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserVehicle.class))),

            @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value ="/vehicle/{plateId}",
            produces = { "application/json" },
            method = RequestMethod.PATCH)
    public ResponseEntity<UserVehicle> updateUserById(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required=true, schema=@Schema()) @PathVariable("plateId") String plateId, @Valid @RequestBody UserVehicle body) {
        try {
            UserVehicle response = new UserVehicle();
            if (plateId != null){
                Optional<UserVehicleEntity> result =userVehicleRepository.findByPlateId(Long.parseLong(plateId));
                result.ifPresent(e -> {
                    e.setPlateId(body.getPlateId());
                    e.setVehicleColor(body.getVehicleColor());
                    e.setVehicleMake(body.getVehicleMake());
                    e.setPlateState(body.getPlateState());
                    e.setVehicleModle(body.getVehicleModle());
                    e.setUserId(Integer.parseInt(body.getUserId()));
                    userVehicleRepository.saveAndFlush(e);
                    BeanUtils.copyProperties(e,response);
                });
            }else {
                return new ResponseEntity<UserVehicle>(response, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<UserVehicle>(response, HttpStatus.OK);
            //  return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Error occurred while Updating data", e);
            return new ResponseEntity<UserVehicle>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
