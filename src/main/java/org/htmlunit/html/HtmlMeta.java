/*
 * Copyright (c) 2002-2025 Gargoyle Software Inc.
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

import java.net.URL;
import java.util.Map;

import org.htmlunit.SgmlPage;
import org.htmlunit.WebClient;

/**
 * Wrapper for the HTML element "meta".
 *
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * @author <a href="mailto:cse@dynabean.de">Christian Sell</a>
 * @author Ahmed Ashour
 * @author Frank Danek
 * @author Ronald Brill
 */
public class HtmlMeta extends HtmlElement {

    /** The HTML tag represented by this element. */
    public static final String TAG_NAME = "meta";

    /**
     * Creates an instance of HtmlMeta
     *
     * @param qualifiedName the qualified name of the element type to instantiate
     * @param page the HtmlPage that contains this element
     * @param attributes the initial attributes
     */
    HtmlMeta(final String qualifiedName, final SgmlPage page,
            final Map<String, DomAttr> attributes) {
        super(qualifiedName, page, attributes);

        // Handles the cookies specified in meta tags,
        // like <code>&lt;meta http-equiv='set-cookie' content='webm=none; path=/;'&gt;</code>.
        if ("set-cookie".equalsIgnoreCase(getHttpEquivAttribute())) {
            final WebClient client = page.getWebClient();
            final URL url = page.getUrl();
            client.addCookie(getContentAttribute(), url, this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean mayBeDisplayed() {
        return false;
    }

    /**
     * Returns the value of the attribute {@code http-equiv}. Refer to the
     * <a href="http://www.w3.org/TR/html401/">HTML 4.01</a>
     * documentation for details on the use of this attribute.
     *
     * @return the value of the attribute {@code http-equiv}
     *         or an empty string if that attribute isn't defined.
     */
    public final String getHttpEquivAttribute() {
        return getAttribute("http-equiv");
    }

    /**
     * Returns the value of the attribute {@code name}. Refer to the
     * <a href="http://www.w3.org/TR/html401/">HTML 4.01</a>
     * documentation for details on the use of this attribute.
     *
     * @return the value of the attribute {@code name}
     *         or an empty string if that attribute isn't defined.
     */
    public final String getNameAttribute() {
        return getAttributeDirect(NAME_ATTRIBUTE);
    }

    /**
     * Returns the value of the attribute {@code content}. Refer to the
     * <a href="http://www.w3.org/TR/html401/">HTML 4.01</a>
     * documentation for details on the use of this attribute.
     *
     * @return the value of the attribute {@code content}
     *         or an empty string if that attribute isn't defined.
     */
    public final String getContentAttribute() {
        return getAttributeDirect("content");
    }

    /**
     * Returns the value of the attribute {@code scheme}. Refer to the
     * <a href="http://www.w3.org/TR/html401/">HTML 4.01</a>
     * documentation for details on the use of this attribute.
     *
     * @return the value of the attribute {@code scheme}
     *         or an empty string if that attribute isn't defined.
     */
    public final String getSchemeAttribute() {
        return getAttributeDirect("scheme");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisplayStyle getDefaultStyleDisplay() {
        return DisplayStyle.NONE;
    }
}
