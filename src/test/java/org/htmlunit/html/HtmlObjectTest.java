/*
 * Copyright (c) 2002-2024 Gargoyle Software Inc.
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
package org.htmlunit.html;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;

import org.htmlunit.CollectingAlertHandler;
import org.htmlunit.MockWebConnection;
import org.htmlunit.SimpleWebTestCase;
import org.htmlunit.WebClient;
import org.htmlunit.junit.BrowserRunner;
import org.htmlunit.junit.BrowserRunner.Alerts;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for {@link HtmlObject}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class HtmlObjectTest extends SimpleWebTestCase {

    private static boolean SKIP_ = false;

    static {
        if (GraphicsEnvironment.isHeadless()) {
            // skip the tests in headless mode
            SKIP_ = true;
        }
    }

    /**
     * @throws Exception if the test fails
     */
    @Test
    @Alerts("undefined")
    public void classid() throws Exception {
        final String html = "<html><head>\n"
            // Window Media Player CLASSID
            + "<object id='wm' classid='clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6'></object>\n"
            + "<script>\n"
            + "  function test() {\n"
            + "    alert(document.all.wm.fullScreen);\n"
            + "  }\n"
            + "</script>\n"
            + "</head><body onload='test()'>\n"
            + "</body></html>";

        final WebClient client = getWebClient();
        final List<String> collectedAlerts = new ArrayList<>();
        client.setAlertHandler(new CollectingAlertHandler(collectedAlerts));

        final MockWebConnection webConnection = new MockWebConnection();
        webConnection.setResponse(URL_FIRST, html);
        client.setWebConnection(webConnection);

        client.getPage(URL_FIRST);
        assertEquals(getExpectedAlerts(), collectedAlerts);
    }
}
