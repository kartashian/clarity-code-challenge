package ai.clarity.challenge.solver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class ExpressionsParserTest {

  private ExpressionsParser parser;

  @BeforeEach
  void setUp() {
    parser = ExpressionsParser.INSTANCE;
  }

  @MethodSource
  @ParameterizedTest
  void shouldParseFile(InputStream fileStream, List<VariableExpression> expectedExpressions) {
    Consumer<VariableExpression> expressionListener = mock(Consumer.class);

    parser.parseFile(fileStream, expressionListener);

    for (VariableExpression expected : expectedExpressions) {
      verify(expressionListener).accept(eq(expected));
    }
  }

  @MethodSource
  @NullSource
  @ParameterizedTest
  void shouldFailToParseFile(InputStream invalidFileStream) {
    assertThrows(RuntimeException.class,
        () -> parser.parseFile(invalidFileStream, mock(Consumer.class)));
  }

  @MethodSource
  @ParameterizedTest
  void shouldParseLine(String expression, VariableExpression expected) {
    VariableExpression parsedExpression = parser.parseLine(expression);

    assertEquals(expected, parsedExpression);
  }

  @MethodSource
  @NullSource
  @ParameterizedTest
  void shouldFailToParseLine(String invalidExpression) {
    assertThrows(RuntimeException.class,
        () -> parser.parseLine(invalidExpression));
  }

  private static Stream<Arguments> shouldParseFile() {
    return Stream.of(
        Arguments.of(
            stringAsInput("a = 1 \n b = a # 1"),
            List.of(
                new VariableExpression("a", List.of("1")),
                new VariableExpression("b", List.of("a", "1"))
            )),
        Arguments.of(
            stringAsInput("a = c # 4 \n b = a # 2 \n c = 35"),
            List.of(
                new VariableExpression("a", List.of("c", "4")),
                new VariableExpression("b", List.of("a", "2")),
                new VariableExpression("c", List.of("35"))
            ))
    );
  }

  private static Stream<Arguments> shouldFailToParseFile() {
    return Stream.of(
        Arguments.of(stringAsInput("a = c = b \n b = a # 1")),
        Arguments.of(stringAsInput("a 1 \n b = a # 4"))
    );
  }

  private static Stream<Arguments> shouldParseLine() {
    return Stream.of(
        Arguments.of("x = 25", new VariableExpression("x", List.of("25"))),
        Arguments.of("y = y # 39 # last", new VariableExpression("y",
            List.of("y", "39", "last"))),
        Arguments.of("x =   y", new VariableExpression("x", List.of("y")))
    );
  }

  private static Stream<Arguments> shouldFailToParseLine() {
    return Stream.of(
        Arguments.of("a == f"),
        Arguments.of("a 1")
    );
  }

  private static InputStream stringAsInput(String string) {
    return new ByteArrayInputStream(string.getBytes());
  }
}
