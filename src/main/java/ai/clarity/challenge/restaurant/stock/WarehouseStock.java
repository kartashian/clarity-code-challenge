package ai.clarity.challenge.restaurant.stock;

import java.math.BigDecimal;
import java.util.Map;

public class WarehouseStock {

  private final Map<BigDecimal, ItemStock> itemStocks;
  private final Map<String, BigDecimal> ingredientsStock;

  public WarehouseStock(
      Map<BigDecimal, ItemStock> itemStocks,
      Map<String, BigDecimal> ingredientsStock) {
    this.itemStocks = itemStocks;
    this.ingredientsStock = ingredientsStock;
  }

  public Map<BigDecimal, ItemStock> getItemStocks() {
    return itemStocks;
  }

  public Map<String, BigDecimal> getIngredientsStock() {
    return ingredientsStock;
  }
}
