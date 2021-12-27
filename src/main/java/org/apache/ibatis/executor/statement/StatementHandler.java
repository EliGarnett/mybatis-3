/**
 * Copyright 2009-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ibatis.executor.statement;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * StatementHandler真正干活的
 *
 * @author Clinton Begin
 */
public interface StatementHandler {

    // 提供获取statement方法
    Statement prepare(Connection connection, Integer transactionTimeout)
            throws SQLException;

    // 设置参数的方法
    void parameterize(Statement statement)
            throws SQLException;

    // 批处理
    void batch(Statement statement)
            throws SQLException;

    // 更新操作
    int update(Statement statement)
            throws SQLException;

    //查询操作
    <E> List<E> query(Statement statement, ResultHandler resultHandler)
            throws SQLException;

    <E> Cursor<E> queryCursor(Statement statement)
            throws SQLException;

    // 获取对应的BoundSql对象，BoundSql对象代表了一个SQL语句，但是还未设置参数
    BoundSql getBoundSql();

    // 获取参数处理对象
    ParameterHandler getParameterHandler();

}
