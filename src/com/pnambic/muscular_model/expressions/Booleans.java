package com.pnambic.muscular_model.expressions;

public class Booleans {

  private Booleans() {
    // Prevent instantiation.
  }

  public static BooleanExpression FALSE = new BooleanExpression.Constant(Boolean.FALSE);

  public static BooleanExpression TRUE = new BooleanExpression.Constant(Boolean.TRUE);

  public static boolean isTrue(Object value) {
    if (value instanceof Boolean) {
      return ((Boolean) value).booleanValue();
    }
    return false;
  }
}
