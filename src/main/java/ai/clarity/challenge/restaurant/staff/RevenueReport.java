package ai.clarity.challenge.restaurant.staff;

import ai.clarity.challenge.restaurant.order.Bill;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class RevenueReport extends Report {

  private final Map<BigDecimal, Bill> incomeBills;
  private final BigDecimal additionalIncome;
  private final BigDecimal totalAmount;

  public RevenueReport(BigDecimal id, LocalDateTime from,
      LocalDateTime to,
      Map<BigDecimal, Bill> incomeBills,
      BigDecimal additionalIncome, BigDecimal totalAmount) {
    super(id, from, to);
    this.incomeBills = incomeBills;
    this.additionalIncome = additionalIncome;
    this.totalAmount = totalAmount;
  }

  public Map<BigDecimal, Bill> getIncomeBills() {
    return incomeBills;
  }

  public BigDecimal getAdditionalIncome() {
    return additionalIncome;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }
}
