package ai.clarity.challenge.restaurant.personal;

public class Cook extends Employee {

  public Cook(String firstName, String surname, Long phoneNumber) {
    super(firstName, surname, phoneNumber);
  }

  @Override
  public EmployeeRole getRole() {
    return EmployeeRole.COOK;
  }
}
