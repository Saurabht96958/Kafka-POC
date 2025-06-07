package com.abc.driver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.driver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {
        int range = 100;
        while(range > 0) {
            System.out.println("in updateLocation");
            cabLocationService.updateLocation(Math.random() +" , "+Math.random());
            Thread.sleep(1000);
            range--;
        }
        return ResponseEntity.ok(Map.of("message", "Location updated"));
    }
}
