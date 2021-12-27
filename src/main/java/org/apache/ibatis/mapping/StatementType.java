/**
 * Copyright 2009-2021 the original author or authors.
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

package org.apache.ibatis.mapping;

/**
 * mybatis中StatementType的值决定了由什么对象来执行SQL语句
 *
 * @author Clinton Begin
 */
public enum StatementType {
    // 对应于statement对象，有SQL注入的风险
    STATEMENT,
    // PreparedStatement对象，预编译处理
    PREPARED,
    // CallableStatement对象，一般调用存储过程的时候使用
    CALLABLE
}
