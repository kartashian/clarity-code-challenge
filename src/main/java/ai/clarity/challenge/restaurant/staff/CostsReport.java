package ai.clarity.challenge.restaurant.staff;

import ai.clarity.challenge.restaurant.staff.Cost.CostType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CostsReport extends Report {

  private final Map<CostType, List<Cost>> costs;
  private final BigDecimal totalAmount;

  public CostsReport(BigDecimal id,
      LocalDateTime from, LocalDateTime to, Map<CostType, List<Cost>> costs,
      BigDecimal totalAmount) {
    super(id, from, to);
    this.costs = costs;
    this.totalAmount = totalAmount;
  }

  public Map<CostType, List<Cost>> getCosts() {
    return costs;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }
}
