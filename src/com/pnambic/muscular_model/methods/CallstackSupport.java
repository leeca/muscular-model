package com.pnambic.muscular_model.methods;

import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;

public interface CallstackSupport {

  Frame enterMethod(Method method);

  void returnWithValue(State state, Object result);

  void simpleReturn(State state);

}
