package com.pnambic.muscular_model;

import java.util.List;
import java.util.Optional;

import com.pnambic.muscular_model.statements.ReturnStatement;

public interface StatementList extends Executable {

  List<Statement> getStatements();

  Optional<ReturnStatement> getTermination();
}
