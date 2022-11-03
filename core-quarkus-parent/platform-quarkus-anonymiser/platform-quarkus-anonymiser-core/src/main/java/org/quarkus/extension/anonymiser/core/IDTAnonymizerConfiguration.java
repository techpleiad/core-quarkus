package org.quarkus.extension.anonymiser.mask;

import io.smallrye.config.ConfigMapping;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@ConfigMapping(prefix = IDTAnonymizerConfiguration.PREFIX)
public interface IDTAnonymizerConfiguration {

    String PREFIX = "dt.config.anonymizer.properties";

    /**
     * Sensitive keys which needs to be anonymized
     */
    Set<String> sensitiveKeys();

    /**
     * String which will be replaced by the sensitive value
     */
//    @ConfigProperty(defaultValue = "**Masked**")
    String maskedString();

    /**
     * Will turn on or off the anonymization
     */
    boolean enabled();

    /**
     * All masking patterns which needs to be checked and their masked value which to be shown after replacing
     */
    List<IDTRegexPattern> maskPatterns();

    interface IDTRegexPattern {
        Pattern pattern();
        String maskedKey();
    }

}