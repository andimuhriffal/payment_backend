package com.teknologi.informasi.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teknologi.informasi.payment.model.Payment;
import com.teknologi.informasi.payment.service.PaymentService;


import java.util.List;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {


   @Autowired
   private PaymentService paymentService;


   // GET semua payment
   @GetMapping
   public List<Payment> getAllPayments() {
       return paymentService.getAll();
   }

   // GET payment berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
       return paymentService.getById(id)
               .map(payment -> ResponseEntity.ok(payment))
               .orElse(ResponseEntity.notFound().build());
   }

   // POST membuat payment baru
   @PostMapping
   public Payment createPayment(@RequestBody Payment payment) {
       return paymentService.createPayment(payment);
   }

   // PUT update payment yang ada
   @PutMapping("/{id}")
   public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
       try {
           Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
           return ResponseEntity.ok(updatedPayment);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }

   // DELETE payment
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deletePayment(@PathVariable Long id) {
       try {
           paymentService.deletePayment(id);
           return ResponseEntity.ok("Payment deleted successfully");
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }
}
