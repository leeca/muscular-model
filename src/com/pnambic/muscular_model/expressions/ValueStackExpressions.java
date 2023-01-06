package com.pnambic.muscular_model.expressions;

import java.util.List;

import com.pnambic.muscular_model.State;

public class ValueStackExpressions {

  private ValueStackExpressions() {
    // Prevent instantiations.
  }

  public static Object popValue(State state) {
    if (state instanceof ValueStackSupport) {
      return ((ValueStackSupport) state).popValue();
    }
    return null;
  }

  public static List<Object> popValueList(State state) {
    if (state instanceof ValueStackSupport) {
      return ((ValueStackSupport) state).popValueList();
    }
    return null;
  }

  public static void pushValue(State state, Object value) {
    if (state instanceof ValueStackSupport) {
      ((ValueStackSupport) state).pushValue(value);
    }
  }

  public static void pushValueList(State state, List<Object> value) {
    if (state instanceof ValueStackSupport) {
      ((ValueStackSupport) state).pushValueList(value);
    }
  }
}
