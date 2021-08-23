package ai.clarity.challenge.restaurant.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

  private final BigDecimal id;
  private final BigDecimal amount;
  private final BigDecimal changeAmount;
  private final PaymentType type;
  private final LocalDateTime time;

  public Payment(BigDecimal id, BigDecimal amount, BigDecimal changeAmount,
      PaymentType type,
      LocalDateTime time) {
    this.id = id;
    this.amount = amount;
    this.changeAmount = changeAmount;
    this.type = type;
    this.time = time;
  }

  public BigDecimal getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getChangeAmount() {
    return changeAmount;
  }

  public PaymentType getType() {
    return type;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public enum PaymentType {
    CASH, CARD, CHECK
  }
}
