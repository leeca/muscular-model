package com.pnambic.muscular_model.methods;

import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.StatementList;

public class SimpleMethod implements Method {

    private final StatementList body;

    public SimpleMethod(StatementList body) {
      this.body = body;
    }

    public void execute(State state) {
      try (Frame frame = Frames.enterMethod(state, this)) {
        body.execute(state);
      } catch (Exception err) {
        throw new RuntimeException("SimpleMethod.execute failure", err);
      }
  }
}
