package ai.clarity.challenge.solver;

import ai.clarity.challenge.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ExpressionsCalculator {

  private static final Optional<Long> ZERO = Optional.of(0L);

  private final Operator operator;
  private final Map<String, Long> variables;
  private final Map<String, List<UnsolvedExpression>> unsolvedExpressionsByVariable;

  public ExpressionsCalculator(Operator operator) {
    this.operator = operator;
    this.variables = new ConcurrentHashMap<>();
    this.unsolvedExpressionsByVariable = new ConcurrentHashMap<>();
  }

  public Optional<Long> getVariable(String variable) {
    return Optional.ofNullable(variables.get(variable));
  }

  public void execute(VariableExpression expression) {
    List<String> arguments = expression.getExpressionArguments();
    UnsolvedExpression unsolved = null;

    long currentValue = 0;
    for (int i = 0; i < arguments.size(); i = i + 2) {
      Optional<Long> current = getArgumentValue(arguments.get(i));
      Optional<Long> next = i + 1 < arguments.size()
          ? getArgumentValue( arguments.get(i + 1)) : ZERO;

      if (current.isEmpty() || next.isEmpty()) {
        if (unsolved == null) {
          unsolved = new UnsolvedExpression(expression);
        }

        if (current.isEmpty()) {
          storeUnsolvedExpression(unsolved, arguments.get(i));
        }

        if (next.isEmpty()) {
          storeUnsolvedExpression(unsolved, arguments.get(i + 1));
        }

        continue;
      }

      long value = operator.operate(current.get(), next.get());
      currentValue = operator.operate(currentValue, value);
    }

    if (unsolved == null) {
      storeVariable(expression.getVariableName(), currentValue);
    }
  }

  private void storeVariable(String variableName, long value) {
    variables.put(variableName, value);

    if (unsolvedExpressionsByVariable.containsKey(variableName)) {
      solveExpressions(unsolvedExpressionsByVariable.get(variableName), variableName);
    }
  }

  private void solveExpressions(List<UnsolvedExpression> unsolvedExpressions,
      String variableName) {
    for (UnsolvedExpression expression : unsolvedExpressions) {
      expression.removeUnknownArgument(variableName);

      if (!expression.hasUnknownArguments()) {
        execute(expression.getExpression());
      }
    }
  }

  private void storeUnsolvedExpression(UnsolvedExpression unsolved, String argument) {
    unsolved.addUnknownArgument(argument);
    unsolvedExpressionsByVariable.compute(argument, (variable, expressions) -> {
      List<UnsolvedExpression> unsolvedExpressions =
          expressions == null ? new ArrayList<>() : expressions;
      if (!unsolvedExpressions.contains(unsolved)) {
        unsolvedExpressions.add(unsolved);
      }

      return unsolvedExpressions;
    });
  }

  private Optional<Long> getArgumentValue(String argument) {
    return parseLong(argument)
        .or(() -> Optional.ofNullable(variables.get(argument)));
  }

  private Optional<Long> parseLong(String strNumber) {
    if (strNumber == null) {
      return Optional.empty();
    }
    try {
      return Optional.of(Long.parseLong(strNumber));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  private static class UnsolvedExpression {

    private final VariableExpression expression;
    private final Set<String> unknownArguments;

    private UnsolvedExpression(VariableExpression expression) {
      this.expression = expression;
      this.unknownArguments = new HashSet<>();
    }

    public VariableExpression getExpression() {
      return expression;
    }

    public void addUnknownArgument(String argument) {
      unknownArguments.add(argument);
    }

    public void removeUnknownArgument(String argument) {
      unknownArguments.remove(argument);
    }

    public boolean hasUnknownArguments() {
      return unknownArguments.size() > 0;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final UnsolvedExpression that = (UnsolvedExpression) o;

      return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
      return expression != null ? expression.hashCode() : 0;
    }
  }
}
