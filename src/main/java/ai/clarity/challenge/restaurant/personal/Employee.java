package ai.clarity.challenge.restaurant.personal;

public abstract class Employee {

  private final String firstName;
  private final String surname;
  private final Long phoneNumber;

  public Employee(String firstName, String surname, Long phoneNumber) {
    this.firstName = firstName;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
  }

  public abstract EmployeeRole getRole();

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }
}
