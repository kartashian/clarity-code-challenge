package ai.clarity.challenge.restaurant.menu;

import java.math.BigDecimal;
import java.util.List;

public class Meal extends Item {

  private final MealType type;
  private final double weight;
  private final List<String> mainIngredients;

  public Meal(BigDecimal id, String name, MealType type, double weight,
      List<String> mainIngredients) {
    super(id, name);
    this.type = type;
    this.weight = weight;
    this.mainIngredients = mainIngredients;
  }

  public MealType getType() {
    return type;
  }

  public double getWeight() {
    return weight;
  }

  public List<String> getMainIngredients() {
    return mainIngredients;
  }

  public enum MealType {
    SALAD,
    APPETIZER,
    SOUP,
    DESERT,
    CHICKEN,
    RICE,
    PASTA,
    PIZZA,
    HOT_MEAL,
    COLD_MEAL,
    SEAFOOD
  }
}
