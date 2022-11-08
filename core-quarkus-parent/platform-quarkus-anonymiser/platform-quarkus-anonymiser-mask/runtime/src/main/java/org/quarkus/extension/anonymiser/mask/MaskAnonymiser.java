package org.quarkus.extension.anonymiser.mask;

import io.vertx.core.MultiMap;
import org.quarkus.extension.anonymiser.core.IDTAnonymizerConfiguration;
import org.quarkus.extension.anonymiser.core.IDataAnonymiser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of IDataAnonymiser which will mask the sensitive data.
 */
@ApplicationScoped
public class MaskAnonymiser implements IDataAnonymiser {

    @Inject
    private IDTAnonymizerConfiguration dtAnonymizerConfiguration;

    @Override
    public Map<String, Object> anonymize(final MultiMap httpHeaders) {
        return anonymize(httpHeaders, headerAnonymizerPredicate);
    }

    @Override
    public Map<String, Object> anonymize(final Map<String, ?> map) {
        return anonymize(map, headerAnonymizerPredicate);
    }

    @Override
    public Object anonymize(final String key, final Object value) {
        return anonymize(key, value, headerAnonymizerPredicate);
    }

    @Override
    public Object anonymize(String key, Object value, Predicate<String> predicate) {
        if (dtAnonymizerConfiguration.enabled() && predicate.test(key)) {
            return dtAnonymizerConfiguration.maskedString();
        }
        return value;
    }

    @Override
    public Map<String, Object> anonymize(MultiMap httpHeaders, Predicate<String> predicate) {
        final Map<String, Object> result = new HashMap<>();
        httpHeaders.forEach((entry) -> {
            System.out.println("anonymize : " + entry.getKey() + ".." + entry.getValue());
            Object anonymize = anonymize(entry.getKey(), entry.getValue(), predicate);
            result.put(entry.getKey(), anonymize);
        });
        return result;
    }

    @Override
    public Map<String, Object> anonymize(Map<String, ?> map, Predicate<String> predicate) {
        final Map<String, Object> result = new HashMap<>(map.size());
        map.forEach((key, value) -> {
            Object anonymize = anonymize(key, value, predicate);
            result.put(key, anonymize);
        });
        return result;
    }

    @Override
    public String anonymize(String message) {
        String result = message;
        final List<IDTAnonymizerConfiguration.IDTRegexPattern> maskPatterns = dtAnonymizerConfiguration.maskPatterns();
        if (!maskPatterns.isEmpty()) {
            for (IDTAnonymizerConfiguration.IDTRegexPattern regexPattern : maskPatterns) {
                result = anonymize(result, regexPattern.pattern(), regexPattern.maskedKey());
            }
        }
        return result;
    }

    @Override
    public String anonymize(String message, Pattern pattern, String maskedValue) {
        return match(message, pattern, maskedValue);
    }

    @Override
    public String anonymize(String message, String pattern, String maskedValue) {
        return match(message, Pattern.compile(pattern, Pattern.CASE_INSENSITIVE), maskedValue);
    }

    private String match(final String msg, final Pattern pattern, final String maskedValue) {
        Matcher keyValMatcher = pattern.matcher(msg);
        return keyValMatcher.replaceAll(maskedValue);
    }

    /**
     * Default predicate which will decide whether to mask the particular key or not.
     * If Anonymization is disabled then it will not anonymize the data.
     */
    private final Predicate<String> headerAnonymizerPredicate = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return dtAnonymizerConfiguration.sensitiveKeys().contains(s.toUpperCase());
        }
    };
}