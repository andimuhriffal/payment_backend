package com.teknologi.informasi.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teknologi.informasi.payment.model.Payment;
import com.teknologi.informasi.payment.repository.PaymentRepository;
import java.util.List;
import java.util.Optional;


@Service
public class PaymentService {


   @Autowired
   private PaymentRepository paymentRepository;


   public List<Payment> getAll() {
       return paymentRepository.findAll();
   }


   public Optional<Payment> getById(Long id) {
       return paymentRepository.findById(id);
   }


   public Payment createPayment(Payment payment) {
       return paymentRepository.save(payment);
   }


   public Payment updatePayment(Long id, Payment paymentDetails) {
       Payment payment = paymentRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
       payment.setOrderNumber(paymentDetails.getOrderNumber());
       payment.setAmount(paymentDetails.getAmount());
       payment.setStatus(paymentDetails.getStatus());
       payment.setPaymentDate(paymentDetails.getPaymentDate());
       return paymentRepository.save(payment);
   }


   public void deletePayment(Long id) {
       Payment payment = paymentRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
       paymentRepository.delete(payment);
   }
}
