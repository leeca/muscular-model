package com.pnambic.muscular_model.statements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.Statement;
import com.pnambic.muscular_model.StatementList;

public class SimpleStatementList implements StatementList {

  private final List<Statement> stmts;

  private final ReturnStatement termination;

  public SimpleStatementList(List<Statement> stmts, ReturnStatement termination) {
    this.stmts = stmts;
    this.termination = termination;
  }

  @Override
  public void execute(State state) {
    for (Statement stmt : stmts) {
      stmt.execute(state);
    }
    if (termination != null) {
      termination.execute(state);
    }
  }

  @Override
  public Optional<ReturnStatement> getTermination() {
    return Optional.ofNullable(termination);
  }

  @Override
  public List<Statement> getStatements() {
    return new ArrayList<>(stmts);
  }
}
