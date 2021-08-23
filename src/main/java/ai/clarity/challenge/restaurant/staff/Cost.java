package ai.clarity.challenge.restaurant.staff;

import ai.clarity.challenge.restaurant.personal.Employee;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cost {

  private final BigDecimal amount;
  private final CostType type;
  private final LocalDateTime date;
  private final String notes;
  private final Employee assigned;

  public Cost(BigDecimal amount, CostType type, LocalDateTime date, String notes,
      Employee assigned) {
    this.amount = amount;
    this.type = type;
    this.date = date;
    this.notes = notes;
    this.assigned = assigned;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public CostType getType() {
    return type;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getNotes() {
    return notes;
  }

  public Employee getAssigned() {
    return assigned;
  }

  public enum CostType {
   SALARY, RENT, INGREDIENTS, DELIVERY, EQUIPMENT, UTILITIES, MARKETING, TAX, DISCOUNT
  }
}
