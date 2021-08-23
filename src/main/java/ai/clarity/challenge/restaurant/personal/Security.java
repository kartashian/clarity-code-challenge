package ai.clarity.challenge.restaurant.personal;

public class Security extends Employee {

  public Security(String firstName, String surname, Long phoneNumber) {
    super(firstName, surname, phoneNumber);
  }

  @Override
  public EmployeeRole getRole() {
    return EmployeeRole.SECURITY;
  }
}
