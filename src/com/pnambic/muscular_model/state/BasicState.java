package com.pnambic.muscular_model.state;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.expressions.ValueStackExpressions;
import com.pnambic.muscular_model.expressions.ValueStackSupport;
import com.pnambic.muscular_model.methods.CallstackSupport;
import com.pnambic.muscular_model.methods.Frame;
import com.pnambic.muscular_model.methods.SimpleFrame;


public class BasicState implements State,
    CallstackSupport,
    ValueStackSupport {

  private final Deque<Object> frameStack;

  private final Deque<Object> valueStack;

  public BasicState() {
    this.frameStack = new ArrayDeque<>();
    this.valueStack = new ArrayDeque<>();
  }

  @Override
  public Object popValue() {
    return valueStack.removeFirst();
  }

  @Override
  public List<Object> popValueList() {
    return (List<Object>) valueStack.removeFirst();
  }

  @Override
  public void pushValue(Object value) {
    valueStack.addFirst(value);
  }

  @Override
  public void pushValueList(List<Object> value) {
    valueStack.addFirst(value);
  }

  @Override
  public Frame enterMethod(Method method) {
    Frame result = new SimpleFrame(method);
    frameStack.addFirst(result);
    return result;
  }

  @Override
  public void returnWithValue(State state, Object value) {
    leaveMethod();
    ValueStackExpressions.pushValue(state, value);
  }

  @Override
  public void simpleReturn(State state) {
    leaveMethod();
  }

  private void leaveMethod() {
    frameStack.removeFirst();
  }
}
