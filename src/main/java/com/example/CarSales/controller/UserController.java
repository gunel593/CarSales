package com.example.CarSales.controller;

import com.example.CarSales.exception.handler.ErrorDetails;
import com.example.CarSales.model.dto.Request.LoginRequest;
import com.example.CarSales.model.dto.Responce.LoginResponce;
import com.example.CarSales.model.dto.Request.RegistrRequest;
import com.example.CarSales.model.dto.Responce.UserResponce;
import com.example.CarSales.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponce>register(@RequestBody RegistrRequest registrRequest){
        UserResponce userResponce = userService.registr(registrRequest);
        return ResponseEntity.ok(userResponce);
    }
    @Operation(description = "for login and get token")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200",description="successful"),
            @ApiResponse(responseCode="400",description="bad request",
            content = @Content(
                    schema =@Schema(implementation = ErrorDetails.class),
                    examples ={
                            @ExampleObject(name="user not exist",value="{\n \"code\": \"1000\",\n \"description\": \"user not exist in db\"\n"),
                            @ExampleObject(name="password wrong",value="{\n \"code\": \"1005\",\n \"description\": \"wrong password\"\n")
                    }
            )),
            @ApiResponse(responseCode="500",description="internal server error",
                    content = @Content(
                            schema =@Schema(implementation = ErrorDetails.class),
                            examples =@ExampleObject(name="internal server error",value="{\n \"code\": \"5500\",\n \"description\": \"exception message\"\n")
                    ))
    }
    )

    @PostMapping("/login")
    public ResponseEntity<LoginResponce>login(@RequestBody LoginRequest loginRequest){
                 LoginResponce loginResponce=userService.login(loginRequest);
        return ResponseEntity.ok(loginResponce);
    }
}
