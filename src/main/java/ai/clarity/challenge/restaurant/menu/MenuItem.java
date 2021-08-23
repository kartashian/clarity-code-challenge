package ai.clarity.challenge.restaurant.menu;

import java.math.BigDecimal;

public class MenuItem {

  private final BigDecimal id;
  private final Item item;
  private final String description;
  private final BigDecimal price;

  public MenuItem(BigDecimal id, Item item, String description, BigDecimal price) {
    this.id = id;
    this.item = item;
    this.description = description;
    this.price = price;
  }

  public BigDecimal getId() {
    return id;
  }

  public Item getItem() {
    return item;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
