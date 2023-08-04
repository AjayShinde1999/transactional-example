package com.transactionalexample.service;


import com.transactionalexample.entity.PassengerInfo;
import com.transactionalexample.entity.PaymentInfo;
import com.transactionalexample.payload.FlightBookingAcknowledgement;
import com.transactionalexample.payload.FlightBookingRequest;
import com.transactionalexample.repository.PassengerInfoRepository;
import com.transactionalexample.repository.PaymentInfoRepository;
import com.transactionalexample.utils.PaymentUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightBookingService {

    private final PassengerInfoRepository passengerInfoRepository;

    private final PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("Success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }
}
