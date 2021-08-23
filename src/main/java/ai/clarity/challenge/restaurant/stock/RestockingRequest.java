package ai.clarity.challenge.restaurant.stock;

import ai.clarity.challenge.restaurant.personal.Manager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class RestockingRequest {

  private final BigDecimal id;
  private final Map<String, BigDecimal> ingredients;
  private final LocalDateTime created;
  private final LocalDateTime dueDate;
  private final Manager manager;

  public RestockingRequest(BigDecimal id,
      Map<String, BigDecimal> ingredients, LocalDateTime created, LocalDateTime dueDate,
      Manager manager) {
    this.id = id;
    this.ingredients = ingredients;
    this.created = created;
    this.dueDate = dueDate;
    this.manager = manager;
  }

  public BigDecimal getId() {
    return id;
  }

  public Map<String, BigDecimal> getIngredients() {
    return ingredients;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public Manager getManager() {
    return manager;
  }
}
