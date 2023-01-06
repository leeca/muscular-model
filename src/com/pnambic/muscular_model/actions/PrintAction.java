package com.pnambic.muscular_model.actions;

import java.util.List;

import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.expressions.ValueStackExpressions;


public class PrintAction implements Method {

  @Override
  public void execute(State state) {
    List<Object> argValues = ValueStackExpressions.popValueList(state);
    for (Object value : argValues) {
      System.out.print(value.toString());
    }
  }
}
