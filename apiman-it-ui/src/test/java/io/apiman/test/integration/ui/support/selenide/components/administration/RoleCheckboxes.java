/*
 * Copyright 2016 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.test.integration.ui.support.selenide.components.administration;

import static com.codeborne.selenide.Selenide.$;

import io.apiman.test.integration.ui.support.selenide.components.PageComponent;

import com.codeborne.selenide.SelenideElement;

/**
 * @author jkaspar
 */
public interface RoleCheckboxes<P> extends PageComponent<P> {

    /**
     * Checkbox - Automatically grant this role when creating a new Organization
     * @return element
     */
    default SelenideElement autoGrantCheckbox() {
        return $("#auto-grant");
    }

    /**
     * Check or uncheck Auto Grant checkbox
     * @param check
     * @return this page object
     */
    default P autoGrant(boolean check) {
        if (autoGrantCheckbox().isSelected() != check) {
            autoGrantCheckbox().click();
        }
        return thisPageObject();
    }

    // TODO: add permissions checkboxes
}
