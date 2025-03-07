package by.it.ragach.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        //2+2 {2,2}  {{2,3},{4,5))/2

        expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION,2);
        String leftOperand = parts[0];
        Var left = Var.createVar(leftOperand);
        if (parts.length==1){
            return left;


        }
        String rightOperand = parts[1];
        Var right = Var.createVar(rightOperand);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return left.add(right);
                case "-":return left.sub(right);
                case "*":return left.mul(right);
                case "/":return left.div(right);


            }
        }



        return null;
    }
}
