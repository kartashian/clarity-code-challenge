package ai.clarity.challenge.restaurant.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bill {

  private final BigDecimal id;
  private final BigDecimal totalAmount;
  private final BigDecimal taxAmount;
  private final BigDecimal discountAmount;
  private final BigDecimal netAmount;
  private final LocalDateTime created;
  private final LocalDateTime updated;
  private final Payment payment;

  public Bill(BigDecimal id, BigDecimal totalAmount,
      BigDecimal taxAmount, BigDecimal discountAmount, BigDecimal netAmount,
      LocalDateTime created,
      LocalDateTime updated, Payment payment) {
    this.id = id;
    this.totalAmount = totalAmount;
    this.taxAmount = taxAmount;
    this.discountAmount = discountAmount;
    this.netAmount = netAmount;
    this.created = created;
    this.updated = updated;
    this.payment = payment;
  }

  public BigDecimal getId() {
    return id;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public BigDecimal getTaxAmount() {
    return taxAmount;
  }

  public BigDecimal getDiscountAmount() {
    return discountAmount;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public BigDecimal getNetAmount() {
    return netAmount;
  }

  public Payment getPayment() {
    return payment;
  }
}
