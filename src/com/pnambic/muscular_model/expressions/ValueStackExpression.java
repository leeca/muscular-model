package com.pnambic.muscular_model.expressions;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.State;

public abstract class ValueStackExpression implements Expression {

  @Override
  public Object getResult(State state) {
    return ValueStackExpressions.popValue(state);
  }
}
