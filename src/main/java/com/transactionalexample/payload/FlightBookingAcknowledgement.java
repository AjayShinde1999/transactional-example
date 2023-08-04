package com.transactionalexample.payload;

import com.transactionalexample.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightBookingAcknowledgement {

    private String status;

    private double totalFare;

    private String pnrNo;

    private PassengerInfo passengerInfo;
}
