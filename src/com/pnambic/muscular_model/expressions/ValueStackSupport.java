package com.pnambic.muscular_model.expressions;

import java.util.List;

public interface ValueStackSupport {

  Object popValue();

  List<Object> popValueList();

  void pushValue(Object value);

  void pushValueList(List<Object> value);

}
