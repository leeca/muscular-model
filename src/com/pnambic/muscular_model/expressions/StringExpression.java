package com.pnambic.muscular_model.expressions;

import com.pnambic.muscular_model.State;

public abstract class StringExpression extends ValueStackExpression {

  @Override
  public String getResult(State state) {
    return (String) super.getResult(state);
  }

  static public class Constant extends StringExpression {

    private final String value;

    public Constant(String value) {
      this.value = value;
    }

    @Override
    public void execute(State state) {
      ValueStackExpressions.pushValue(state, value);
    }
  }

  static public abstract class Unary extends StringExpression {

    private final StringExpression expr;

    public Unary(StringExpression expr) {
      this.expr = expr;
    }

    @Override
    public void execute(State state) {
      expr.execute(state);
      Object result = ValueStackExpressions.popValue(state);
      ValueStackExpressions.pushValue(state, unaryOp(result));
    }

    protected abstract String unaryOp(Object value);
  }

  static public abstract class Binary extends StringExpression {

    private final StringExpression left;

    private final StringExpression right;

    public Binary(StringExpression left, StringExpression right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public void execute(State state) {
      left.execute(state);
      Object leftValue = ValueStackExpressions.popValue(state);
      right.execute(state);
      Object rightValue = ValueStackExpressions.popValue(state);
      ValueStackExpressions.pushValue(state, binaryOp(leftValue, rightValue));
    }

    protected abstract Object binaryOp(Object leftValue, Object rightValue);
  }
}
