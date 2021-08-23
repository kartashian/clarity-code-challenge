package ai.clarity.challenge.restaurant.order;

import ai.clarity.challenge.restaurant.menu.Item;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItem {

  private final BigDecimal id;
  private final Item item;
  private final int amount;
  private final BigDecimal price;
  private final OrderItemStatus status;
  private final LocalDateTime createDate;

  public OrderItem(BigDecimal id, Item item, int amount, BigDecimal price,
      OrderItemStatus status, LocalDateTime createDate) {
    this.id = id;
    this.item = item;
    this.amount = amount;
    this.price = price;
    this.status = status;
    this.createDate = createDate;
  }

  public BigDecimal getId() {
    return id;
  }

  public int getAmount() {
    return amount;
  }

  public Item getItem() {
    return item;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public OrderItemStatus getStatus() {
    return status;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public enum OrderItemStatus {
    NEW, COOKING, SERVED, RETURNED, FAILED
  }
}
