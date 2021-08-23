package ai.clarity.challenge.restaurant.menu;

import java.math.BigDecimal;

public class Drink extends Item {

  private final String brand;
  private final String type;
  private final int yearOfProduction;
  private final double volume;

  public Drink(BigDecimal id, String name, String brand, String type, int yearOfProduction,
      double volume) {
    super(id, name);
    this.brand = brand;
    this.type = type;
    this.yearOfProduction = yearOfProduction;
    this.volume = volume;
  }

  public int getYearOfProduction() {
    return yearOfProduction;
  }

  public double getVolume() {
    return volume;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }
}
