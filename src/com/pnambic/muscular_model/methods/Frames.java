package com.pnambic.muscular_model.methods;

import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;

public class Frames {

  private Frames() {
    // Prevent instantiation.
  }

  public static Frame enterMethod(State state, Method method) {
    if (state instanceof CallstackSupport) {
      ((CallstackSupport) state).enterMethod(method);
    }

    return null;
  }

  public static void returnWithValue(State state, Object result) {
    if (state instanceof CallstackSupport) {
      ((CallstackSupport) state).returnWithValue(state, result);
    }
  }

  public static void simpleReturn(State state) {
    if (state instanceof CallstackSupport) {
      ((CallstackSupport) state).simpleReturn(state);
    }
  }
}
