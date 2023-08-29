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
package org.htmlunit.libraries;

import org.htmlunit.junit.BrowserRunner;
import org.htmlunit.junit.BrowserRunner.Alerts;
import org.htmlunit.junit.BrowserRunner.HtmlUnitNYI;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for <a href="https://htmx.org/">htmx</a>.
 *
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class HtmxTest1x9x5 extends HtmxTest {

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = "passes:616failures:1",
            FF = "passes:616failures:0",
            FF_ESR = "passes:616failures:0",
            IE = "not testable")
    @HtmlUnitNYI(
            CHROME = "passes:616failures:0",
            EDGE = "passes:616failures:0",
            IE = "passes:91failures:533")
    public void htmx() throws Exception {
        htmx("htmx-1.9.5");
    }
}