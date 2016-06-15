/*
 * Copyright (c) 2002-2016 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.html;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.BrowserRunner;
import com.gargoylesoftware.htmlunit.SimpleWebTestCase;

/**
 * Tests for {@link HtmlOrderedList}.
 *
 * @author Ahmed Ashour
 * @author Marc Guillemot
 */
@RunWith(BrowserRunner.class)
public class HtmlOrderedListTest extends SimpleWebTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    public void asText() throws Exception {
        final String html = "<html><head>\n"
            + "</head><body>\n"
            + "  <ol id='foo'>\n"
            + "  <li>first item</li>\n"
            + "  <li>second item</li>\n"
            + "  </ol>\n"
            + "  </table>\n"
            + "</body></html>";

        final HtmlPage page = loadPage(html);
        final HtmlElement node = page.getHtmlElementById("foo");
        final String expectedText = "1. first item" + LINE_SEPARATOR + "2. second item";

        assertEquals(expectedText, node.asText());
        assertEquals(expectedText, page.asText());
    }

    /**
     * Browsers ignore closing information in a self closing OL tag.
     * @throws Exception if the test fails
     */
    @Test
    public void asXml() throws Exception {
        final String content
            = "<html><head></head><body>\n"
            + "<ol id='myNode'></ol>\n"
            + "foo\n"
            + "</form></body></html>";
        final HtmlPage page = loadPage(content);
        final HtmlElement element = page.getHtmlElementById("myNode");

        assertEquals("<ol id=\"myNode\">\r\n</ol>\r\n", element.asXml());
        assertTrue(page.asXml().contains("</ol>"));
    }
}
