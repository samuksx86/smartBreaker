package com.smartBreaker.controller;

import com.smartBreaker.model.EnergyStatusResponse;
import com.smartBreaker.service.EnergyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    @GetMapping("/status")
    public ResponseEntity<EnergyStatusResponse> getStatusByLatLon(
            @RequestParam double lat,
            @RequestParam double lon
    ) {
        EnergyStatusResponse status = energyService.getStatusByCoordinates(lat, lon);
        return ResponseEntity.ok(status);
    }
}
