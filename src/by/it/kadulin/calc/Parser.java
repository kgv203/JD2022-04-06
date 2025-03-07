package by.it.kadulin.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATIONS, 2);
        String leftOperand = parts[0];
        Var left = Var.createVar(parts[0]);
        if (parts.length == 1) {
            return left;
        }
        String rightOperand = parts[1];
        Var right = Var.createVar(parts[1]);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);

            }
        }
        return null;
    }
}
