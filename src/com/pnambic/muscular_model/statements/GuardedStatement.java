package com.pnambic.muscular_model.statements;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.Statement;
import com.pnambic.muscular_model.StatementList;
import com.pnambic.muscular_model.expressions.Booleans;


public class GuardedStatement implements Statement {

  private final Expression guard;

  private final StatementList body;

  public GuardedStatement(Expression guard, StatementList body) {
    this.guard = guard;
    this.body = body;
  }

  @Override
  public void execute(State state) {
    if (isGuardTrue(state)) {
      body.execute(state);
    }
  }

  private boolean isGuardTrue(State state) {
    guard.execute(state);
    return Booleans.isTrue(guard.getResult(state));
  }
}
