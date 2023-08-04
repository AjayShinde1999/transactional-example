package com.transactionalexample.controller;

import com.transactionalexample.payload.FlightBookingAcknowledgement;
import com.transactionalexample.payload.FlightBookingRequest;
import com.transactionalexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/booking")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/ticket")
    public FlightBookingAcknowledgement flightBook(@RequestBody FlightBookingRequest request){
        return flightBookingService.bookFlightTicket(request);
    }
}
