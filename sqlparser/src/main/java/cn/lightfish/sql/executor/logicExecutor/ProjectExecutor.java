package cn.lightfish.sql.executor.logicExecutor;

import cn.lightfish.sql.ast.expr.ValueExpr;
import cn.lightfish.sql.schema.SimpleColumnDefinition;

public class ProjectExecutor extends AbsractExecutor {

  private final ValueExpr[] exprs;
  final Executor executor;

  public ProjectExecutor(SimpleColumnDefinition[] columnDefinitions, ValueExpr[] exprs,Executor executor) {
    super(columnDefinitions);
    this.exprs = exprs;
    this.executor = executor;
  }
  @Override
  public boolean hasNext() {
    return this.executor.hasNext();
  }

  @Override
  public Object[] next() {
    executor.next();
    Object[] res = new Object[exprs.length];
    for (int i = 0; i <exprs.length; i++) {
      res[i] = exprs[i].getValue();
    }
    return res;
  }
}