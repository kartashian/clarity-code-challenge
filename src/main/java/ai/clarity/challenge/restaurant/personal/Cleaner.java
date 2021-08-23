package ai.clarity.challenge.restaurant.personal;

public class Cleaner extends Employee {

  public Cleaner(String firstName, String surname, Long phoneNumber) {
    super(firstName, surname, phoneNumber);
  }

  @Override
  public EmployeeRole getRole() {
    return EmployeeRole.CLEANER;
  }
}
