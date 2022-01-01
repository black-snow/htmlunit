/*
 * Copyright (c) 2002-2022 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.util.geometry;

/**
 * Simple 2D shape interface.
 *
 * @author Ronald Brill
 */
public interface Shape2D {

    /** Constant used for comparing doubles. */
    double epsilon = 0.0000001;

    /**
     * @param x point x value
     * @param y point y value
     * @return <code>true</code> if the specified point is inside;
     *         <code>false</code> otherwise.
     */
    boolean contains(double x, double y);

    /**
     * @return <code>true</code> if the Shape is empty.
     */
    boolean isEmpty();
}
