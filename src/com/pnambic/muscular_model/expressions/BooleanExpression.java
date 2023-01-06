package com.pnambic.muscular_model.expressions;

import com.pnambic.muscular_model.State;

public abstract class BooleanExpression extends ValueStackExpression {

  @Override
  public Boolean getResult(State state) {
    return (Boolean) super.getResult(state);
  }

  static public class Constant extends BooleanExpression {

    private final Boolean value;

    public Constant(Boolean value) {
      this.value = value;
    }

    @Override
    public void execute(State state) {
      ValueStackExpressions.pushValue(state, value);
    }
  }

  static public abstract class Unary extends BooleanExpression {

    private final BooleanExpression expr;

    public Unary(BooleanExpression expr) {
      this.expr = expr;
    }

    @Override
    public void execute(State state) {
      expr.execute(state);
      Object result = ValueStackExpressions.popValue(state);
      ValueStackExpressions.pushValue(state, unaryOp(result));
    }

    protected abstract Boolean unaryOp(Object value);
  }

  static public abstract class BinaryBooleanExpression extends BooleanExpression {

    private final BooleanExpression left;

    private final BooleanExpression right;

    public BinaryBooleanExpression(BooleanExpression left, BooleanExpression right) {
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

  static public class NotBooleanExpression extends Unary {

    public NotBooleanExpression(BooleanExpression expr) {
      super(expr);
    }

    @Override
    protected Boolean unaryOp(Object value) {
      if (Booleans.isTrue(value)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
  }

  static public class AndBooleanExpression extends BinaryBooleanExpression {

    public AndBooleanExpression(BooleanExpression left, BooleanExpression right) {
      super(left, right);
    }

    @Override
    protected Object binaryOp(Object leftValue, Object rightValue) {
      boolean isLeftTrue = Booleans.isTrue(leftValue);
      boolean isRightTrue = Booleans.isTrue(rightValue);
      return Boolean.valueOf(isLeftTrue & isRightTrue);
    }
  }

  static public class OrBooleanExpression extends BinaryBooleanExpression {

    public OrBooleanExpression(BooleanExpression left, BooleanExpression right) {
      super(left, right);
    }

    @Override
    protected Object binaryOp(Object leftValue, Object rightValue) {
      boolean isLeftTrue = Booleans.isTrue(leftValue);
      boolean isRightTrue = Booleans.isTrue(rightValue);
      return Boolean.valueOf(isLeftTrue | isRightTrue);
    }
  }
}
