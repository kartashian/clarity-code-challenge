package ai.clarity.challenge.restaurant.staff;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Report {

  private final BigDecimal id;
  private final LocalDateTime from;
  private final LocalDateTime to;

  public Report(BigDecimal id, LocalDateTime from, LocalDateTime to) {
    this.id = id;
    this.from = from;
    this.to = to;
  }

  public BigDecimal getId() {
    return id;
  }

  public LocalDateTime getFrom() {
    return from;
  }

  public LocalDateTime getTo() {
    return to;
  }
}
