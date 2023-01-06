package com.pnambic.muscular_model.statements;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.Statement;


public class ExpressionStatement implements Statement {

  private Expression expr;

  public ExpressionStatement(Expression expr) {
    this.expr = expr;
  }

  @Override
  public void execute(State state) {
    expr.execute(state);
  }
}
