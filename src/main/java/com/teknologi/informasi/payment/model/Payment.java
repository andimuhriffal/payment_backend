package com.teknologi.informasi.payment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "payments")
public class Payment {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  
   private String orderNumber;
   private Double amount;
   private String status;
   private LocalDateTime paymentDate;
  
   // Constructor tanpa parameter
   public Payment() {}


   // Constructor dengan parameter
   public Payment(String orderNumber, Double amount, String status, LocalDateTime paymentDate) {
       this.orderNumber = orderNumber;
       this.amount = amount;
       this.status = status;
       this.paymentDate = paymentDate;
   }


   // Getters dan Setters
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getOrderNumber() {
       return orderNumber;
   }
   public void setOrderNumber(String orderNumber) {
       this.orderNumber = orderNumber;
   }
   public Double getAmount() {
       return amount;
   }
   public void setAmount(Double amount) {
       this.amount = amount;
   }
   public String getStatus() {
       return status;
   }
   public void setStatus(String status) {
       this.status = status;
   }
   public LocalDateTime getPaymentDate() {
       return paymentDate;
   }
   public void setPaymentDate(LocalDateTime paymentDate) {
       this.paymentDate = paymentDate;
   }
}
