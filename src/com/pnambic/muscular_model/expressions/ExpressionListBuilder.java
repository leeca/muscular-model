package com.pnambic.muscular_model.expressions;

import java.util.ArrayList;
import java.util.List;

import com.pnambic.muscular_model.Expression;

public class ExpressionListBuilder {

  private final List<Expression> exprs = new ArrayList<>();

  public void addExpression(Expression expr) {
    exprs.add(expr);
  }

  public SimpleExpressionList build() {
    return new SimpleExpressionList(exprs);
  }
}
