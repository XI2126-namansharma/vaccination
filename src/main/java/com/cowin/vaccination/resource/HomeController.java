package com.cowin.vaccination.resource;

import com.cowin.vaccination.service.AvailabilityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vaccination")
public class HomeController {

    @Autowired
    AvailabilityService availabilityService;

    @GetMapping("/pin-code")
    @Operation(summary = "Sample API for the service", description = "This is example of the Api doc.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JSONObject.class))})
    })
    public JSONObject showAPI(@RequestParam String pinCode, @RequestParam String date) {
        return availabilityService.availability(pinCode,date);
    }
}
