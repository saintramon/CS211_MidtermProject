package Project1.backend;

public class Test {
    private static final Expressions expressions = new Expressions();
    public static void main(String[] args) {
        String infix = "(a+b)*(c-d)";
        System.out.println(infix);

        String postfix = expressions.convertToPostfix(infix);
        System.out.println(postfix);


        String postfixTest = "12+34+*";
        System.out.println(expressions.evaluatePostfix(postfixTest));
    }
}
