package by.it.kadulin.calc;

abstract class Var implements Operation {
    public static Var createVar(String stringVar) {
        Var result = null;
        if (stringVar.matches(Patterns.SCALAR)) {
            result = new Scalar(stringVar);
        }
        else if (stringVar.matches(Patterns.VECTOR)) {
            result = new Vector(stringVar);
        }
        else if (stringVar.matches(Patterns.MATRIX)) {
            result = new Matrix(stringVar);
        }
        return result;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Incorrect operation %s + %s%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Incorrect operation %s - %s%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Incorrect operation %s * %s%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Incorrect operation %s / %s%n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}
