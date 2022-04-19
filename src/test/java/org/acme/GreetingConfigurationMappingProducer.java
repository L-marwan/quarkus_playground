package org.acme;

import io.quarkus.test.Mock;
import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class GreetingConfigurationMappingProducer {

    @Inject
    Config config;

    @Produces
    @ApplicationScoped
    @Mock
    GreetingConfiguration greetingConfiguration() {
        return config.unwrap(SmallRyeConfig.class).getConfigMapping(GreetingConfiguration.class);
    }
}
