package org.quarkus.extension.atom.anonymiser.core;

import io.vertx.core.MultiMap;

import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Data Anonymiser contract which will anonymise the data.
 */
public interface IDataAnonymiser {

    /**
     * Method will anonymise the HTTPHeaders on the basis of SensitiveKeys provided in DTAnonymizerConfiguration.
     *
     * @param httpHeaders Headers which need to be masked
     * @return Will return either masked or normal value of headers
     */
    Map<String, Object> anonymize(final MultiMap httpHeaders);

    /**
     * Method will anonymise the Key,Values pair on the basis of SensitiveKeys provided in DTAnonymizerConfiguration.
     *
     * @param map Key,Value which need to be masked
     * @return Will return either masked or normal value of headers
     */
    Map<String, Object> anonymize(final Map<String, ?> map);

    /**
     * Will Anonymize the key on the basis of SensitiveKeys provided in DTAnonymizerConfiguration.
     *
     * @param key   Key which need to be anonymised
     * @param value Sensitive value
     * @return Either masked or normal
     */
    Object anonymize(final String key, final Object value);

    /**
     * Will Anonymize the key on the basis of the predicate which user will provide.
     *
     * @param key       Key which need to be anonymized
     * @param value     Sensitive value
     * @param predicate This will decide whether to mask or not.
     * @return Either masked or normal
     */
    Object anonymize(final String key, final Object value, final Predicate<String> predicate);

    /**
     * Method will anonymise the HTTPHeaders on the basis of the predicate which user will provide.
     *
     * @param httpHeaders Headers which need to be masked
     * @param predicate   This will decide whether to mask or not.
     * @return Will return either masked or normal value of headers
     */
    Map<String, Object> anonymize(final MultiMap httpHeaders, final Predicate<String> predicate);

    /**
     * Method will anonymise the Key,Values pair on the basis of predicate which user will provide.
     *
     * @param map       Key,Value which need to be masked
     * @param predicate This will decide whether to mask or not.
     * @return Will return either masked or normal value of headers
     */
    Map<String, Object> anonymize(final Map<String, ?> map, final Predicate<String> predicate);

    /**
     * Method will mask the message on the basis of the regex pattern provided in the configuration.
     * @param message Message which needs to be masked
     * @return Will return the normal or masked message
     */
    String anonymize(final String message);

    /**
     * Method will mask the message on the basis of the regex pattern provided.
     * @param message Message which needs to be masked
     * @param pattern Regex pattern which will decide whether to mask or not
     * @param maskedValue Value which will be used for masking
     * @return Will return the normal or masked message
     */
    String anonymize(final String message, String pattern, String maskedValue);

    String anonymize(final String message, Pattern pattern, String maskedValue);

}
