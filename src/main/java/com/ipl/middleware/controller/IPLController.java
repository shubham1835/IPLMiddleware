package com.ipl.middleware.controller;

import com.ipl.middleware.dto.IplMatchBidDTO;
import com.ipl.middleware.service.IplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/app/v1/ipl")
@Validated
@CrossOrigin
public class IPLController {

    @Autowired
    IplService iplService;

    @GetMapping(value = "/matchList")
    public ResponseEntity<?> matchList() {
        System.out.println("matchList========>");
        return new ResponseEntity<>(iplService.matchList(), HttpStatus.OK);
    }

    @PostMapping(value = "/bid")
    public ResponseEntity<?> bid(@Valid @RequestBody IplMatchBidDTO iplMatchBidDTO) {
        iplService.postBid(iplMatchBidDTO);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
