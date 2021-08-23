package ai.clarity.challenge.restaurant.menu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Menu {

  private final BigDecimal id;
  private final String name;
  private final MenuType type;
  private final Map<MenuChapter, List<MenuItem>> chapters;

  public Menu(BigDecimal id, String name, MenuType type,
      Map<MenuChapter, List<MenuItem>> chapters) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.chapters = chapters;
  }

  public BigDecimal getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public MenuType getType() {
    return type;
  }

  public Map<MenuChapter, List<MenuItem>> getChapters() {
    return chapters;
  }

  public enum MenuType {
    DAILY_MENU, WEEKEND_MENU, HAPPY_HOUR
  }

  public enum MenuChapter {
    SALADS, DRINKS, APPETIZERS, MAIN, PASTA, VEGETABLES, GRILL, DESSERTS
  }
}
