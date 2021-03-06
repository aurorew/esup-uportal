/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.portal.url;

/**
 * Represents the rendering state of the portal, all available states should be enumerated here
 * 
 * @author Eric Dalquist
 * @version $Revision$
 */
public enum UrlState {
    /* IMPORTANT, all enum keys must be completely upper case for the helper methods to not cause problems */
    
    /**
     * Rendering with multiple portlets in the view
     */
    NORMAL,
    /**
     * Rendering a single portlet with portal provided UI
     */
    MAX,
    /**
     * Rendering a single portlet with portal markup but no portal rendered UI
     */
    DETACHED,
    /**
     * Rendering a single portlet where the portlet is responsible for all output, binary output is supported.
     */
    EXCLUSIVE;
    
    private final String lowercase;
    
    private UrlState() {
        this.lowercase = this.toString().toLowerCase();
    }
    
    public String toLowercaseString() {
        return this.lowercase;
    }
    
    public static UrlState valueOfIngoreCase(String name) {
        return UrlState.valueOf(name.toUpperCase());
    }
    
    public static UrlState valueOfIngoreCase(String name, UrlState defaultValue) {
        if (name == null) {
            return defaultValue;
        }
        
        try {
            return valueOfIngoreCase(name);
        }
        catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }
}