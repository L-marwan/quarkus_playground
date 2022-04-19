package org.acme;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {
    @Inject
    GreetingConfiguration greetingConfiguration;

    public String getGreeting() {
        return greetingConfiguration.getMessage() + " " + greetingConfiguration.getName().get();
    }

}
