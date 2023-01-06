package com.pnambic.muscular_model.hello_world;

import com.pnambic.muscular_model.Expression;
import com.pnambic.muscular_model.Method;
import com.pnambic.muscular_model.State;
import com.pnambic.muscular_model.Statement;
import com.pnambic.muscular_model.actions.PrintAction;
import com.pnambic.muscular_model.expressions.ExpressionListBuilder;
import com.pnambic.muscular_model.expressions.ObjectExpression;
import com.pnambic.muscular_model.expressions.StringExpression;
import com.pnambic.muscular_model.methods.MethodCall;
import com.pnambic.muscular_model.methods.SimpleMethod;
import com.pnambic.muscular_model.state.BasicState;
import com.pnambic.muscular_model.statements.ExpressionStatement;
import com.pnambic.muscular_model.statements.StatementListBuilder;

public class HelloWorld {

  public static void main(String[] args) {
    ExpressionListBuilder printArgs = new ExpressionListBuilder();
    Expression helloWorld = new StringExpression.Constant("Hello, World!");
    printArgs.addExpression(helloWorld);

    Method printAction = new PrintAction();
    Expression printName = new ObjectExpression(printAction);
    Expression printCall = new MethodCall(printName, printArgs.build());

    Statement printStatement = new ExpressionStatement(printCall);
    StatementListBuilder body = new StatementListBuilder();
    body.addStatement(printStatement);

    Method helloWorldMethod = new SimpleMethod(body.buildSimpleReturn());

    State state = new BasicState();
    helloWorldMethod.execute(state);
  }
}
