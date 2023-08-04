package com.transactionalexample.payload;

import com.transactionalexample.entity.PassengerInfo;
import com.transactionalexample.entity.PaymentInfo;
import lombok.Data;

@Data
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
