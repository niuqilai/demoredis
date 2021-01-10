package org.atech.dbi.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.sql.Statement;
import java.util.Properties;

/**
 * Sql执行时间记录拦截器
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })})
public class SqlCostInterceptor implements Interceptor {

    public SqlCostInterceptor() {
    }
    Logger logger = LoggerFactory.getLogger(SqlCostInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        long startTime = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        final BoundSql boundSql = statementHandler.getBoundSql();
        try {
            return invocation.proceed();
        } finally {

            final StringBuilder build = new StringBuilder(7);
            build.append("\n");
            build.append("------------sql执行耗时计算开始---------------");
            build.append("\n");
            build.append("SQL:");
            build.append(boundSql.getSql());
            build.append("\n");
            build.append("MYBATIS-SQL执行耗时:[");
            build.append((System.currentTimeMillis() - startTime));
            build.append("ms]");
            build.append("\n");
            build.append("------------sql执行耗时计算结束---------------");
            logger.warn(build.toString());
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}