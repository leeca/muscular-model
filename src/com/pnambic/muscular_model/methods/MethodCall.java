package com.pnambic.muscular_model.methods;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.expressions.SimpleExpressionList;
import com.pnambic.muscular_model.expressions.ValueStackExpression;
import com.pnambic.muscular_model.expressions.ValueStackExpressions;

public class MethodCall extends ValueStackExpression {

  private final Expression method;

  private final SimpleExpressionList args;

  public MethodCall(Expression method, SimpleExpressionList args) {
    this.method = method;
    this.args = args;
  }

  @Override
  public void execute(State state) {
    method.execute(state);
    Object methodValue = ValueStackExpressions.popValue(state);

    args.execute(state);

    ((Method) methodValue).execute(state);
  }
}
