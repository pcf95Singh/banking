package com.example.banking.controller;

import com.example.banking.entity.UserProfile;
import com.example.banking.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Profile Management", description = "APIs for creating and fetching banking customer profile")
public class UserController {

    @Autowired
    private UserServices services;

    //1 Get All users
    @Operation(summary = "Get All registered customers", description = "Returns a full list of all baking customers in the system")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched customers"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<UserProfile> getAllUsers(){
        return services.getAllUsers();
    }

    //2 Get Single User by Id
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id){
        UserProfile user = services.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //3 Create new account
    @PostMapping
    @Operation(summary = "New customer", description = "Create new bank account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<UserProfile> createUser(@Valid@RequestBody UserProfile userProfile){

        UserProfile savedUser = services.createUser(userProfile);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
