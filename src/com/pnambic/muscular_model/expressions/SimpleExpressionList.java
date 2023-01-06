package com.pnambic.muscular_model.expressions;

import java.util.ArrayList;
import java.util.List;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.State;

public class SimpleExpressionList extends ValueStackExpression {

  private final List<Expression> exprs;

  public SimpleExpressionList(List<Expression> exprs) {
    this.exprs = exprs;
  }

  @Override
  public void execute(State state) {
    List<Object> result = new ArrayList<>(exprs.size());
    for(Expression expr : exprs) {
      expr.execute(state);
      result.add(expr.getResult(state));
    }
    ValueStackExpressions.pushValueList(state, result);
  }

  @Override
  public List<Object> getResult(State state) {
    return ValueStackExpressions.popValueList(state);
  }
}
