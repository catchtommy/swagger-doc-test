package com.sample.poc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Operation(
            operationId = "Get sample object",
            summary = "Get sample object",
            description = "API to Get sample object",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Get sample object successfully", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SampleObj.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Unsupported JSON format", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                            @Schema(implementation = Object.class))
                    }),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/sample/{id}")
    public SampleObj getSample(@PathVariable Long id) {
        SampleObj sampleObj = new SampleObj();
        sampleObj.setAge("40");
        sampleObj.setName("Tom Thomas");
        return sampleObj;
    }

    @Operation(
            operationId = "create sample object",
            summary = "create sample object",
            description = "API to create sample object",
            responses = {
                    @ApiResponse(responseCode = "201", description = "post sample object successfully", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SampleObj.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Unsupported JSON format", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                            @Schema(implementation = Object.class))
                    }),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @PostMapping("/sample")
    public SampleObj createSample(@RequestBody SampleObj sample) {
        return sample;
    }
}
