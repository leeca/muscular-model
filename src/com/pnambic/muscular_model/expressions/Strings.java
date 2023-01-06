package com.pnambic.muscular_model.expressions;


public class Strings {

  public static String getText(Object value) {
    if (value instanceof String) {
      return (String) value;
    }
    return null;
  }
}
