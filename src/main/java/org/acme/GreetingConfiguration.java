package org.acme;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@ConfigMapping(prefix ="greeting")
public interface GreetingConfiguration {
    @WithName("message")
    String getMessage();

    @WithName("suffix")
    @WithDefault("!")
    String getSuffix();

    @WithName("name")
    Optional<String> getName();

    @WithName("content")
    ContentConfig getContent();

    interface ContentConfig{
        @Positive
        @WithName("prizeAmount")
        Integer getPrizeAmount();

        @WithName("recipients")
        List<String> getRecipients();
    }
}
