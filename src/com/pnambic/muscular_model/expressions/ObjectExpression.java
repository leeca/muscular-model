package com.pnambic.muscular_model.expressions;

import com.pnambic.muscular_model.State;


public class ObjectExpression extends ValueStackExpression {

  private final Object object;

  public ObjectExpression(Object object) {
    this.object = object;
  }

  @Override
  public void execute(State state) {
    ValueStackExpressions.pushValue(state, object);
  }
}
