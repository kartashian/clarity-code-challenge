package ai.clarity.challenge.restaurant.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OrderHistory {

  private final Order order;
  private final List<OrderStatusHistoryRecord> history;
  private final Map<BigDecimal, List<OrderStatusHistoryRecord>> orderItemsHistory;

  public OrderHistory(Order order,
      List<OrderStatusHistoryRecord> history,
      Map<BigDecimal, List<OrderStatusHistoryRecord>> orderItemsHistory) {
    this.order = order;
    this.history = history;
    this.orderItemsHistory = orderItemsHistory;
  }

  public Order getOrder() {
    return order;
  }

  public List<OrderStatusHistoryRecord> getHistory() {
    return history;
  }

  public Map<BigDecimal, List<OrderStatusHistoryRecord>> getOrderItemsHistory() {
    return orderItemsHistory;
  }
}
