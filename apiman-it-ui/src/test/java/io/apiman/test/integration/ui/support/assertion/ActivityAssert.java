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

package io.apiman.test.integration.ui.support.assertion;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.apiman.test.integration.SuiteProperties;
import io.apiman.test.integration.runner.RestAssuredConfig;
import io.apiman.manager.api.beans.orgs.OrganizationBean;

import java.util.concurrent.TimeUnit;

/**
 * @author jcechace, ldimaggi
 */
public class ActivityAssert {

    static {
        RestAssuredConfig.init();
    }

    /**
     * Asserts that the most recent activity log entry matches the expected orgBean, entity, and action (what)
     *
     * @param expected org
     * @param expected entity
     * @param expected action (what)
     *
     * Supported values - as of December 2015
     * entityType: Organization | Client | Plan | Api
     * what: Create | Update | Delete | Clone | Grant | Revoke | Publish | Retire | Register | 
     * Unregister | AddPolicy | RemovePolicy | UpdatePolicy | ReorderPolicies | CreateContract | 
     * BreakContract | Lock | UpdateDefinition | DeleteDefinition
     */
    public static void assertLatestActivity(OrganizationBean expected, String entityType, String what)
        throws InterruptedException {
        TimeUnit.SECONDS.sleep(Integer.valueOf(SuiteProperties.getProperty("time.delay")));
        final String path = "/organizations/{org}/activity/";
       
        /* Select the activity listed first on page 1 */
        given().
            parameters("page", "1", "count", "1").
        when().
            get(path, expected.getName()).
        then().
            statusCode(200).
            body("beans[0].organizationId", equalTo(expected.getName())).
            body("beans[0].what", equalTo(what)).
            body("beans[0].entityType", equalTo(entityType));
    }

}
