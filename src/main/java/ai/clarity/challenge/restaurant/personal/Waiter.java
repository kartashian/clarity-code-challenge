package ai.clarity.challenge.restaurant.personal;

public class Waiter extends Employee {

  public Waiter(String firstName, String surname, Long phoneNumber) {
    super(firstName, surname, phoneNumber);
  }

  @Override
  public EmployeeRole getRole() {
    return EmployeeRole.WAITER;
  }
}
