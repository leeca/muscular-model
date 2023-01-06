package com.pnambic.muscular_model.statements;

import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.methods.Frames;


public class SimpleReturnStatement implements ReturnStatement {

  @Override
  public void execute(State state) {
    Frames.simpleReturn(state);
  }

}
