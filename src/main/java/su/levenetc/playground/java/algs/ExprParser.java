package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

public class ExprParser {

    public ExprNode parse(String str) {

        Deque<Operator> opStack = new LinkedList<>();
        Deque<ExprNode> exprStack = new LinkedList<>();

        for (char ch : str.toCharArray()) {

            if (isOperator(ch)) {
                Operator operator = Operator.valueOf(ch);

                if (operator == Operator.BRACK_OPEN) {

                    opStack.push(operator);

                } else if (operator == Operator.BRACK_CLOSE) {
                    while (opStack.peek() != Operator.BRACK_OPEN) {
                        Operator pop = opStack.pop();
                        ExprNode expr2 = exprStack.pop();
                        ExprNode expr1 = exprStack.pop();
                        exprStack.push(new ExprNode(pop, expr1, expr2));
                    }

                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && opStack.peek().prec >= operator.prec) {
                        Operator pop = opStack.pop();
                        ExprNode expr2 = exprStack.pop();
                        ExprNode expr1 = exprStack.pop();
                        exprStack.push(new ExprNode(pop, expr1, expr2));
                    }

                    opStack.push(operator);
                }

            } else {
                exprStack.push(new ExprNode(ch - '0'));
            }


        }

        return exprStack.pop();
    }

    private boolean isOperator(char ch) {
        return Operator.valueOf(ch) != null;
    }

    enum Operator {

        BRACK_OPEN(0),
        BRACK_CLOSE(0),
        MULT(1),
        DIVIDE(2),
        ADD(3),
        SUB(4);

        int prec;

        Operator(int prec) {
            this.prec = prec;
        }

        public static Operator valueOf(char ch) {
            if (ch == '+') {
                return ADD;
            } else if (ch == '-') {
                return SUB;
            } else if (ch == '/') {
                return DIVIDE;
            } else if (ch == '*') {
                return MULT;
            } else if (ch == '(') {
                return BRACK_OPEN;
            } else if (ch == ')') {
                return BRACK_CLOSE;
            } else {
                return null;
            }
        }
    }

    static class ExprNode {

        Operator operator;
        int num;
        ExprNode operand1;
        ExprNode operand2;

        public ExprNode(int num) {
            this.num = num;
        }

        public ExprNode(Operator operator, ExprNode operand1, ExprNode operand2) {
            this.operator = operator;
            this.operand1 = operand1;
            this.operand2 = operand2;
        }
    }

}
