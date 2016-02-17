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

package io.apiman.test.integration.ui.support.selenide.pages.organizations;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import io.apiman.test.integration.ui.support.selenide.PageLocation;
import io.apiman.test.integration.ui.support.selenide.layouts.OrgEntitiesListPage;
import io.apiman.test.integration.ui.support.selenide.pages.plans.CreatePlanPage;

import com.codeborne.selenide.SelenideElement;

/**
 * @author jkaspar
 */
@PageLocation("/apimanui/api-manager/orgs/{0}/plans")
public class OrgPlansListPage extends OrgEntitiesListPage<OrgPlansListPage> {

    /**
     * New Plan button
     * @return element
     */
    public SelenideElement newPlanButton() {
        return $("a[data-field='toNewPlan']");
    }

    /**
     * Click to New Plan button
     * @return CreatePlanPage
     */
    public CreatePlanPage newPlan() {
        newPlanButton().click();
        return page(CreatePlanPage.class);
    }
}
