package ai.clarity.challenge.restaurant.personal;

public class Manager extends Employee {

  public Manager(String firstName, String surname, Long phoneNumber) {
    super(firstName, surname, phoneNumber);
  }

  @Override
  public EmployeeRole getRole() {
    return EmployeeRole.MANAGER;
  }
}
