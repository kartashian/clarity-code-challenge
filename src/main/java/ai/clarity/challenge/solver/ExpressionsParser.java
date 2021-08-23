package ai.clarity.challenge.solver;

import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ExpressionsParser {

  INSTANCE;

  private static final Logger LOGGER = LogManager.getLogger(ExpressionsParser.class);
  private static final String OPERATION_PLACEHOLDER = "#";

  public void parseFile(InputStream fileStream,
      Consumer<VariableExpression> onNewExpressionListener) {
    requireNonNull(fileStream, "fileStream must not be null");
    requireNonNull(onNewExpressionListener, "onNewExpressionListener must not be null");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream))) {
      for (String line; (line = reader.readLine()) != null; ) {
        VariableExpression expression = parseLine(line);
        onNewExpressionListener.accept(expression);
      }
    } catch (IOException e) {
      LOGGER.error("Failed to parse the expressions file", e);
      throw new RuntimeException(e);
    }
  }

  public VariableExpression parseLine(String expression) {
    Objects.requireNonNull(expression, "Expression must not be null");

    String[] parts = expression.replaceAll("\\s", "").split("=");
    if (parts.length != 2) {
      throw new IllegalArgumentException("Invalid expression: " + expression);
    }
    
    String variableName = parts[0];
    LinkedList<String> expressionArguments = Stream.of(parts[1].split(OPERATION_PLACEHOLDER))
        .collect(Collectors.toCollection(LinkedList::new));
    return new VariableExpression(variableName, expressionArguments);
  }
}
