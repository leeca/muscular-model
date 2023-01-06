package com.pnambic.muscular_model;

public interface Expression extends Executable {

  Object getResult(State state);
}
