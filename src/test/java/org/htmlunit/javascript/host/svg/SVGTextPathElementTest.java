/*
 * Copyright (c) 2002-2023 Gargoyle Software Inc.
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
package org.htmlunit.javascript.host.svg;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.htmlunit.WebDriverTestCase;
import org.htmlunit.html.HtmlPageTest;
import org.htmlunit.junit.BrowserRunner;
import org.htmlunit.junit.BrowserRunner.Alerts;
import org.htmlunit.junit.BrowserRunner.NotYetImplemented;

/**
 * Tests for {@link SVGTextPathElement}.
 *
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class SVGTextPathElementTest extends WebDriverTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = "function SVGTextPathElement() { [native code] }",
            IE = "[object SVGTextPathElement]")
    public void simpleScriptable() throws Exception {
        final String html = HtmlPageTest.STANDARDS_MODE_PREFIX_
            + "<html><head>\n"
            + "<script>\n"
            + LOG_TITLE_FUNCTION
            + "  function test() {\n"
            + "    log(window.SVGTextPathElement);\n"
            + "  }\n"
            + "</script>\n"
            + "</head><body onload='test()'>\n"
            + "</body></html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts({"[object SVGTextPathElement]", "true"})
    public void getComputedTextLengthAvailable() throws Exception {
        final String html = HtmlPageTest.STANDARDS_MODE_PREFIX_
            + "<html><head>\n"
            + "<script>\n"
            + LOG_TITLE_FUNCTION
            + "  function test() {\n"
            + "    if (window.SVGPathElement) {\n"
            + "      var text = document.getElementById('myId');\n"
            + "      log(text);\n"
            + "      log(text.getComputedTextLength() > 0);\n"
            + "    }\n"
            + "  }\n"
            + "</script>\n"
            + "</head><body onload='test()'>\n"
            + "<svg width='100%' height='100%' viewBox='0 0 400 400' xmlns='http://www.w3.org/2000/svg'>\n"
            + "  <defs>\n"
            + "    <path id='myTextPath' d='M 50,100 Q 150,50 250,100' />\n"
            + "  </defs>\n"
            + "  <text fill='steelblue' font-size='20'>\n"
            + "    <textPath id='myId' xlink:href='#myTextPath'>Heho</textPath>\n"
            + "  </text>\n"
            + "</svg>\n"
            + "</body></html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts(DEFAULT = {"[object SVGTextPathElement]", "43.3"},
            IE = {"[object SVGTextPathElement]", "49.3"})
    @NotYetImplemented
    public void getComputedTextLength() throws Exception {
        final String html = HtmlPageTest.STANDARDS_MODE_PREFIX_
            + "<html><head>\n"
            + "<script>\n"
            + LOG_TITLE_FUNCTION
            + "  function test() {\n"
            + "    if (window.SVGTextElement) {\n"
            + "      var text = document.getElementById('myId');\n"
            + "      log(text);\n"
            + "      var length = text.getComputedTextLength();\n"
            + "      log(length.toFixed(1));\n"
            + "    }\n"
            + "  }\n"
            + "</script>\n"
            + "</head><body onload='test()'>\n"
            + "<svg width='100%' height='100%' viewBox='0 0 400 400' xmlns='http://www.w3.org/2000/svg'>\n"
            + "  <defs>\n"
            + "    <path id='myTextPath' d='M 50,100 Q 150,50 250,100' />\n"
            + "  </defs>\n"
            + "  <text fill='steelblue' font-size='20'>\n"
            + "    <textPath id='myId' xlink:href='#myTextPath'>Heho</textPath>\n"
            + "  </text>\n"
            + "</svg>\n"
            + "</body></html>";

        loadPageVerifyTitle2(html);
    }
}