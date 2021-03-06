/*
 * Copyright (c) 2015 Spotify AB.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.heroic.grammar;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * Representation of a let expression.
 * <p>
 * These take the form: {@code let &lt;reference&gt; = &lt;expression&gt;}
 */
@Data
@JsonTypeName("let")
public class LetExpression implements Expression {
    private final Context context;
    private final ReferenceExpression reference;
    private final Expression expression;

    @Override
    public <R> R visit(final Visitor<R> visitor) {
        return visitor.visitLet(this);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public String toRepr() {
        return String.format("let %s = %s", reference.toRepr(), expression.toRepr());
    }
}
