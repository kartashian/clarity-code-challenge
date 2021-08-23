package ai.clarity.challenge.solver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExpressionsCalculatorTest {

  private ExpressionsCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new ExpressionsCalculator(Long::sum);
  }

  @MethodSource
  @ParameterizedTest
  void shouldExecuteAndFindVariable(List<VariableExpression> expression, String variable, Long expected) {
    expression.forEach(calculator::execute);

    Optional<Long> actual = calculator.getVariable(variable);

    assertEquals(expected, actual.get());
  }

  @MethodSource
  @ParameterizedTest
  void shouldExecuteAndNotFindVariable(List<VariableExpression> expression, String variable) {
    expression.forEach(calculator::execute);

    Optional<Long> actual = calculator.getVariable(variable);

    assertTrue(actual.isEmpty());
  }

  public static Stream<Arguments> shouldExecuteAndFindVariable() {
    return Stream.of(
        Arguments.of(
            List.of(
                new VariableExpression("a", List.of("1")),
                new VariableExpression("b", List.of("a", "1"))
            ),
            "b", 2L
        ),
        Arguments.of(
            List.of(
                new VariableExpression("a", List.of("c")),
                new VariableExpression("b", List.of("24")),
                new VariableExpression("c", List.of("b", "35"))
            ),
            "c", 59L
        )
    );
  }

  public static Stream<Arguments> shouldExecuteAndNotFindVariable() {
    return Stream.of(
      Arguments.of(
          List.of(
              new VariableExpression("a", List.of("b")),
              new VariableExpression("b", List.of("c"))
          ), "a"
      ),
      Arguments.of(
          List.of(
              new VariableExpression("a", List.of("35")),
              new VariableExpression("b", List.of("21"))
          ), "c"
      ),
      Arguments.of(
          List.of(
              new VariableExpression("a", List.of("last")),
              new VariableExpression("b", List.of("21"))
          ), "a"
      )
    );
  }
}
