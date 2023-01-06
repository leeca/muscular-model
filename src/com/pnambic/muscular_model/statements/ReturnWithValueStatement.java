package com.pnambic.muscular_model.statements;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.expressions.ValueStackExpressions;
import com.pnambic.muscular_model.methods.Frames;


public class ReturnWithValueStatement implements ReturnStatement {

  private final Expression expr;

  public ReturnWithValueStatement(Expression expr) {
    this.expr = expr;
  }

  @Override
  public void execute(State state) {
    expr.execute(state);
    Object result = ValueStackExpressions.popValue(state);
    Frames.returnWithValue(state, result);
  }
}
