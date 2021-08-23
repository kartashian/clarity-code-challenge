package ai.clarity.challenge.restaurant.order;

import ai.clarity.challenge.restaurant.order.OrderItem.OrderItemStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemStatusHistoryRecord {

  private final BigDecimal id;
  private final OrderItemStatus status;
  private final LocalDateTime changeTime;
  private final OrderItemStatusHistoryRecord previousRecord;
  private final String additionalNote;

  public OrderItemStatusHistoryRecord(
      BigDecimal id, OrderItemStatusHistoryRecord previousRecord,
      OrderItemStatus status, LocalDateTime changeTime, String additionalNote) {
    this.id = id;
    this.previousRecord = previousRecord;
    this.status = status;
    this.changeTime = changeTime;
    this.additionalNote = additionalNote;
  }

  public BigDecimal getId() {
    return id;
  }

  public OrderItemStatusHistoryRecord getPreviousRecord() {
    return previousRecord;
  }

  public OrderItemStatus getStatus() {
    return status;
  }

  public LocalDateTime getChangeTime() {
    return changeTime;
  }

  public String getAdditionalNote() {
    return additionalNote;
  }
}
