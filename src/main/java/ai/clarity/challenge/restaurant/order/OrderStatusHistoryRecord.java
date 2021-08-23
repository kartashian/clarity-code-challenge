package ai.clarity.challenge.restaurant.order;

import ai.clarity.challenge.restaurant.order.Order.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderStatusHistoryRecord {

  private final BigDecimal id;
  private final OrderStatus status;
  private final LocalDateTime changeTime;
  private final OrderStatusHistoryRecord previousRecord;
  private final String additionalNote;

  public OrderStatusHistoryRecord(
      BigDecimal id, OrderStatusHistoryRecord previousRecord,
      OrderStatus status, LocalDateTime changeTime, String additionalNote) {
    this.id = id;
    this.previousRecord = previousRecord;
    this.status = status;
    this.changeTime = changeTime;
    this.additionalNote = additionalNote;
  }

  public BigDecimal getId() {
    return id;
  }

  public OrderStatusHistoryRecord getPreviousRecord() {
    return previousRecord;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public LocalDateTime getChangeTime() {
    return changeTime;
  }

  public String getAdditionalNote() {
    return additionalNote;
  }
}
