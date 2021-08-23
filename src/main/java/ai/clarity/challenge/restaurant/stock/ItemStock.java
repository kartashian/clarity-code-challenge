package ai.clarity.challenge.restaurant.stock;

import ai.clarity.challenge.restaurant.menu.Item;
import java.math.BigDecimal;
import java.util.Map;

public class ItemStock {

  private final BigDecimal id;
  private final Item item;
  private final BigDecimal itemStock;
  private final Map<String, BigDecimal> ingredientsStock;

  public ItemStock(BigDecimal id, Item item,
      BigDecimal itemStock, Map<String, BigDecimal> ingredientsStock) {
    this.id = id;
    this.item = item;
    this.itemStock = itemStock;
    this.ingredientsStock = ingredientsStock;
  }

  public BigDecimal getId() {
    return id;
  }

  public Item getItem() {
    return item;
  }

  public BigDecimal getItemStock() {
    return itemStock;
  }

  public Map<String, BigDecimal> getIngredientsStock() {
    return ingredientsStock;
  }
}
