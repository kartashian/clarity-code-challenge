package ai.clarity.challenge.solver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.clarity.challenge.Solution;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class SolverTest {

  private static Supplier<InputStream> stringAsInput(String string) {
    return () -> new ByteArrayInputStream(string.getBytes());
  }

  @Test
  public void solve1plus2() {
    // given
    String string =
        "a = 1 # 2";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "a");

    // when
    Solution solution = solver.solve();

    // then
    assertEquals(Optional.of(3L), solution.getValue());
  }

  @Test
  public void solveForward() {
    // given
    String string =
        "myvar = 1 # 2\n" +
            "forwardResult = myvar # 2";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "forwardResult");

    // when
    Solution solution = solver.solve();

    // then
    assertEquals(Optional.of(5L), solution.getValue());
  }

  @Test
  public void solveBackward() {
    // given
    String string =
        "fun = last # 2\n" +
            "backwardResult = fun # last # 3\n" +
            "last = 1\n";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "backwardResult");

    // when
    Solution solution = solver.solve();

    // then
    assertEquals(Optional.of(7L), solution.getValue());
  }

  @Test
  public void solveBackwardComplex() {
    // given
    String string =
        "fun = last # 2\n" +
            "backwardResult1 = fun # last # 3\n" +
            "backwardResult2 = backwardResult3 # last # 3\n" +
            "backwardResult3 = backwardResult1 # last # 3\n" +
            "last = 1\n";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "backwardResult2");

    // when
    Solution solution = solver.solve();

    // then
    assertEquals(Optional.of(15L), solution.getValue());
  }

  @Test
  public void solveNoSolution() {
    // given
    String string =
        "x = y # 2\n" +
            "z = x # y # 3";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "z");

    // when
    Solution solution = solver.solve();

    // then
    assertTrue(solution.getValue().isEmpty());
  }

  @Test
  public void solveLoop() {
    // given
    String string =
        "look1 = 2 # look2 \n" +
            "look2 = look3 # 99 # 12\n" +
            "look3 = 1 # look1";

    Solver solver = new Solver(stringAsInput(string), Long::sum, "look1");

    // when
    Solution solution = solver.solve();

    // then
    assertTrue(solution.getValue().isEmpty());
  }
}
