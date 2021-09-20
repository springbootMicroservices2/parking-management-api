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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import southalabamahealth.parkingmanagement.models.User;
import southalabamahealth.parkingmanagement.models.UserCreate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
public class UsersApiController {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Operation(summary = "Create an User", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "returns newly created user", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "500", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody UserCreate body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "delete  a specific user", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/users/{Id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required=true, schema=@Schema()) @PathVariable("Id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "List all users", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))),

            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "500", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers(@Parameter(in = ParameterIn.QUERY, description = "How many items to return at one time (max 100)" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<User>>(objectMapper.readValue("[ {\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}, {\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Info for a specific user", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/users/{Id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<User> showUserById(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required=true, schema=@Schema()) @PathVariable("Id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Update a specific user", description = "", tags={ "users-api-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/users/{Id}",
            produces = { "application/json" },
            method = RequestMethod.PATCH)
    public ResponseEntity<User> updateUserById(@Parameter(in = ParameterIn.PATH, description = "The id of the User to retrieve", required=true, schema=@Schema()) @PathVariable("Id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"warnings\" : [ {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"comments\" : \"comments\",\n    \"file\" : [ \"\", \"\" ],\n    \"location\" : \"location\",\n    \"id\" : 6,\n    \"directSupervisor\" : \"directSupervisor\",\n    \"userId\" : \"userId\",\n    \"createDate\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"contactNumber\" : \"contactNumber\",\n  \"id\" : 0,\n  \"MiddleName\" : \"MiddleName\",\n  \"department\" : \"department\",\n  \"supervisor\" : \"supervisor\",\n  \"email\" : \"email\",\n  \"driverType\" : \"driverType\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

}
