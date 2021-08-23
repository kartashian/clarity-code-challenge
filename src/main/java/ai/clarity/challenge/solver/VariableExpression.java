package ai.clarity.challenge.solver;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.Objects;

public class VariableExpression {

  private final String variableName;
  private final List<String> expressionArguments;

  public VariableExpression(String variableName,
      List<String> expressionArguments) {
    this.variableName = variableName;
    this.expressionArguments = unmodifiableList(expressionArguments);
  }

  public String getVariableName() {
    return variableName;
  }

  public List<String> getExpressionArguments() {
    return expressionArguments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final VariableExpression that = (VariableExpression) o;

    if (!Objects.equals(variableName, that.variableName)) {
      return false;
    }
    return Objects.equals(expressionArguments, that.expressionArguments);
  }

  @Override
  public int hashCode() {
    int result = variableName != null ? variableName.hashCode() : 0;
    result = 31 * result + (expressionArguments != null ? expressionArguments.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "VariableExpression{" +
        "variableName='" + variableName + '\'' +
        ", expressionArguments=" + expressionArguments +
        '}';
  }
}
