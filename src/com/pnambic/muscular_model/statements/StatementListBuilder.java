package com.pnambic.muscular_model.statements;

import java.util.ArrayList;
import java.util.List;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.Statement;
import com.pnambic.muscular_model.StatementList;

public class StatementListBuilder {
  private final List<Statement> stmts = new ArrayList<>();

  public void addStatement(Statement stmt) {
    if (stmt instanceof ReturnStatement) {
      return;
    }
    stmts.add(stmt);
  }

  public StatementList buildSimpleReturn() {
    ReturnStatement termination = new SimpleReturnStatement();
    return new SimpleStatementList(stmts, termination);
  }

  public StatementList buildValueReturn(Expression expr) {
    ReturnStatement termination = new ReturnWithValueStatement(expr);
    return new SimpleStatementList(stmts, termination);
  }

  public StatementList buildFallthrough() {
    return new SimpleStatementList(stmts, null);
  }
}
