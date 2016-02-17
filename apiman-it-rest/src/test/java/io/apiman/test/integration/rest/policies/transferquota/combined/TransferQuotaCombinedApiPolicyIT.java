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

package io.apiman.test.integration.rest.policies.transferquota.combined;

import io.apiman.test.integration.DeployedServices;
import io.apiman.test.integration.runner.annotations.misc.Endpoint;
import io.apiman.test.integration.runner.annotations.misc.ManagedEndpoint;
import io.apiman.test.integration.runner.annotations.misc.Policies;
import io.apiman.test.integration.runner.annotations.version.ApiVersion;

/**
 * @author jkaspar
 */
public class TransferQuotaCombinedApiPolicyIT extends AbstractTransferQuotaCombinedPolicyIT {

    @ApiVersion(api = "api", policies = @Policies(value = "transfer_001", params = {"direction", "both"}),
        endpoint = @Endpoint(DeployedServices.DOWNLOAD_ENDPOINT))
    @ManagedEndpoint
    private static String endpoint;

    @Override
    protected String getResourceURL() {
        return endpoint;
    }
}
