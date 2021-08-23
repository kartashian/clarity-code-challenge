package ai.clarity.challenge.restaurant.staff;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProfitReport extends Report {

  private final BigDecimal totalRevenue;
  private final BigDecimal costs;
  private final BigDecimal netIncome;

  public ProfitReport(BigDecimal id, LocalDateTime from, LocalDateTime to,
      BigDecimal totalRevenue, BigDecimal costs, BigDecimal netIncome) {
    super(id, from, to);
    this.totalRevenue = totalRevenue;
    this.costs = costs;
    this.netIncome = netIncome;
  }

  public BigDecimal getTotalRevenue() {
    return totalRevenue;
  }

  public BigDecimal getCosts() {
    return costs;
  }

  public BigDecimal getNetIncome() {
    return netIncome;
  }
}
