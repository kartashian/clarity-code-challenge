package ai.clarity.challenge.restaurant.menu;

import java.math.BigDecimal;

public class Item {

  private final BigDecimal id;
  private final String name;

  public Item(BigDecimal id, String name) {
    this.id = id;
    this.name = name;
  }

  public BigDecimal getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
