package org.hackathon.aidtracker.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @GetMapping("/401")
    public String _401() {
        return "you don't have permission";
    }
}
