package ai.clarity.challenge.solver;

import static ai.clarity.challenge.Solution.newFoundSolution;
import static ai.clarity.challenge.Solution.newUnknownSolution;

import ai.clarity.challenge.Operator;
import ai.clarity.challenge.Solution;
import java.io.InputStream;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Solver {

  private static final Logger LOGGER = LogManager.getLogger(Solver.class);

  private final Supplier<InputStream> input;
  private final String variable;
  private final Operator operator;

  public Solver(Supplier<InputStream> input, Operator operator, String variable) {
    this.input = input;
    this.operator = operator;
    this.variable = variable;
  }

  /**
   * Solve variable
   *
   * @return The solution for the target variable.
   */
  public Solution solve() {
    try {
      ExpressionsCalculator calculator = new ExpressionsCalculator(operator);
      parseFile(calculator);

      return calculator.getVariable(variable)
          .map(value -> newFoundSolution(variable, value))
          .orElseGet(() -> newUnknownSolution(variable));
    } catch (Exception e) {
      LOGGER.error("Error during expressions solving", e);
      return newUnknownSolution(variable);
    }
  }

  private void parseFile(ExpressionsCalculator calculator) {
    try {
      ExpressionsParser.INSTANCE.parseFile(input.get(), expression -> {
        calculator.execute(expression);

        if (calculator.getVariable(variable).isPresent()) {
          throw new VariableFoundException();
        }
      });
    } catch (VariableFoundException ignored) {
    }
  }

  private static class VariableFoundException extends RuntimeException {

    public VariableFoundException() {
      super(null, null, true, false);
    }
  }
}
