package by.it._classwork_.calc.contants;

public class Patterns {
    public static final String OPERATION = "[-+*/=]";
    public static final String SPACES = "\\s+";

    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
