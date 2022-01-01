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
package com.gargoylesoftware.htmlunit.javascript.host.css;

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;

/**
 * A JavaScript object for {@code CSS2Properties}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@JsxClass({FF, FF_ESR})
public class CSS2Properties extends ComputedCSSStyleDeclaration {

    /**
     * Creates an instance.
     */
    @JsxConstructor
    public CSS2Properties() {
    }

    /**
     * Creates an instance.
     *
     * @param style the original Style
     */
    public CSS2Properties(final CSSStyleDeclaration style) {
        super(style);
    }

}
