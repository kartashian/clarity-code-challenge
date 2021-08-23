package ai.clarity.challenge.restaurant.order;

import ai.clarity.challenge.restaurant.personal.Waiter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

  private final BigDecimal id;
  private final List<OrderItem> items;
  private final LocalDateTime created;
  private final LocalDateTime updated;
  private final OrderStatus status;
  private final Bill bill;
  private final BigDecimal totalPrice;
  private final Waiter waiter;

  public Order(BigDecimal id, List<OrderItem> items,
      OrderStatus status, BigDecimal totalPrice, LocalDateTime created,
      LocalDateTime updated, Bill bill, Waiter waiter) {
    this.id = id;
    this.items = items;
    this.created = created;
    this.updated = updated;
    this.status = status;
    this.totalPrice = totalPrice;
    this.bill = bill;
    this.waiter = waiter;
  }

  public BigDecimal getId() {
    return id;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public Bill getBill() {
    return bill;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public Waiter getWaiter() {
    return waiter;
  }

  public enum OrderStatus {
    NEW, COOKING, ALL_ITEMS_READY, PAID
  }
}
