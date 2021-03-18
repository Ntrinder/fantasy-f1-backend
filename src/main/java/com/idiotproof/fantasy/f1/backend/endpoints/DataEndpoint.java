package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataEndpoint {

    @Autowired
    DataService dataService;

    /**
     * Calls ergast.com f1 api.
     * @return drivers for latest f1 season: json -> string
     */
    @GetMapping("/update-drivers")
    public String updateDrivers() {
        return dataService.updateDrivers();
    }
}

