/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.ignite.configuration;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import org.apache.ignite.client.ClientCacheConfiguration;

/**
 * Ignite cache configuration.
 */
@EachProperty(value = IgniteThinCacheConfiguration.PREFIX, primary = "default")
public class IgniteThinCacheConfiguration {
    public static final String PREFIX = IgniteConfig.PREFIX + "." + "thin-caches";

    private final String name;
    private String client = "default";

    @ConfigurationBuilder(excludes = {"name", "keyConfiguration", "queryEntities"})
    private final ClientCacheConfiguration configuration = new ClientCacheConfiguration();

    /**
     * @param name Name or key for client.
     */
    public IgniteThinCacheConfiguration(@Parameter String name) {
        this.name = name;
        configuration.setName(name);
    }

    /**
     * @param client name of client to reference when building cache.
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return name of client to reference when building cache.
     */
    public String getClient() {
        return client;
    }

    /**
     * @return ignite cache configuration.
     */
    public ClientCacheConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * @return name or key for client.
     */
    @NonNull
    public String getName() {
        return this.name;
    }
}
