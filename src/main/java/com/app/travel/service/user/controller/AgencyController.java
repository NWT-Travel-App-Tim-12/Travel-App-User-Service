package com.app.travel.service.user.controller;


import com.app.travel.service.user.model.entity.Agency;
import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.service.AgencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/agencies")
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
//bump
    @PostMapping(path = "")
    @PreAuthorize("#header=='ADMIN'")
    public @ResponseBody ResponseEntity<Agency> addAgency(@RequestBody @Valid Agency agency, @RequestHeader("role") String header ) {
        return new ResponseEntity<>(agencyService.addAgency(agency), HttpStatus.OK);
    }
}
