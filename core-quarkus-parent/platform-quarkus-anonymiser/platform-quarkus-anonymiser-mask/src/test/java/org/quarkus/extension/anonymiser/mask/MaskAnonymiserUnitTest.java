//https://github.com/quarkusio/quarkus/issues/27010


//package org.quarkus.extension.anonymiser.mask;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.vertx.http.runtime.QuarkusHttpHeaders;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import javax.inject.Inject;
//import java.util.*;
//
//@QuarkusTest
//class MaskAnonymiserUnitTest {
//
//    @Inject
//    private MaskAnonymiser maskAnonymiser;
//
//    @Test
//    public void givenSensitiveKeyAndValue_whenAnonymized_thenReturnMaskedValue() {
//        //Given:
//        final String sensitiveKey = "authorization";
//        final String value = "Bearer Token";
//        final String normalKey = "Tenant";
//
//        //When:
//        final Object anonymizedValue = maskAnonymiser.anonymize(sensitiveKey, value);
//        final Object normalValue = maskAnonymiser.anonymize(normalKey, "pl");
//
//        //Then:
//        Assertions.assertNotNull(anonymizedValue);
//        Assertions.assertEquals("**Masked**", anonymizedValue);
//        Assertions.assertNotNull(normalValue);
//        Assertions.assertEquals("pl", normalValue);
//    }
//
//    @Test
//    public void givenSensitiveKeyAndValueMap_whenAnonymized_thenReturnMaskedMap() {
//        //Given:
//        final String sensitiveKey = "authorization";
//        final String sensitiveValue = "Bearer Token";
//        final String normalKey = "Tenant";
//        final Map<String, String> map = new HashMap<>();
//        map.put(sensitiveKey, sensitiveValue);
//        map.put("user-token", sensitiveValue);
//        map.put(normalKey, "pl");
//
//        //When:
//        final Map<String, Object> result = maskAnonymiser.anonymize(map);
//
//        //Then:
//        Assertions.assertEquals("**Masked**", result.get(sensitiveKey));
//        Assertions.assertEquals("**Masked**", result.get("user-token"));
//        Assertions.assertEquals("pl", result.get(normalKey));
//    }
//
//    @Test
//    public void givenSensitiveKeyAndCollectionValueMap_whenAnonymized_thenReturnMaskedMap() {
//        //Given:
//        final String sensitiveKey = "authorization";
//        final String sensitiveValue = "Bearer Token";
//        final String normalKey = "Tenant";
//        final Map<String, Collection<String>> map = new HashMap<>();
//        map.put(sensitiveKey, Collections.singletonList(sensitiveValue));
//        map.put("user-token", Collections.singletonList(sensitiveValue));
//        map.put(normalKey, Collections.singletonList("pl"));
//
//        //When:
//        final Map<String, Object> result = maskAnonymiser.anonymize(map);
//
//        //Then:
//        Assertions.assertEquals("**Masked**", result.get(sensitiveKey));
//        Assertions.assertEquals("**Masked**", result.get("user-token"));
//        Assertions.assertEquals("pl", ((List) result.get(normalKey)).get(0));
//    }
//
//    @Test
//    public void givenHttpHeaders_whenAnonymized_thenReturnResult() {
//        //Given:
////        final HttpHeaders httpHeaders = new HttpHeaders();
//        final QuarkusHttpHeaders httpHeaders = new QuarkusHttpHeaders();
//        final String sensitiveKey = "authorization";
//        final String sensitiveValue = "Bearer Token";
//        final String normalKey = "Tenant";
//        httpHeaders.add(sensitiveKey, Collections.singletonList(sensitiveValue));
//        httpHeaders.add("user-token", Collections.singletonList(sensitiveValue));
//        httpHeaders.add(normalKey, Collections.singletonList("pl"));
//
//        //When:
//        final Map<String, Object> result = maskAnonymiser.anonymize(httpHeaders);
//
//        //Then:
//        Assertions.assertEquals("**Masked**", result.get(sensitiveKey));
//        Assertions.assertEquals("**Masked**", result.get("user-token"));
//        Assertions.assertEquals("pl", ((List) result.get(normalKey)).get(0));
//    }
//
//    @Test
//    void givenPattern1_whenAnonymize_thenMaskPassword() {
//        //given
////        final List<IDTAnonymizerConfiguration.IDTRegexPattern> maskPatterns = new ArrayList<>();
////        maskPatterns.add(new IDTAnonymizerConfiguration.IDTRegexPattern(Pattern
////                .compile("(password[\\w\\d\\s.-]*?)(\"[\\s]*:[\\s]*\")(\\S+?)(\".*?)", CASE_INSENSITIVE), "$1$2**Masked**$4"));
////        Mockito.when(IDTAnonymizerConfiguration.getMaskPatterns()).thenReturn(maskPatterns);
//
//        //when
//        final String input = "{\"password-2.4 Ghz\":\"abc123\"}";
//        final String anonymized = maskAnonymiser.anonymize(input);
//
//        //then
//        Assertions.assertEquals("{\"password-2.4 Ghz\":\"**Masked**\"}", anonymized);
//    }
//
//    @Test
//    void givenPattern2_whenAnonymize_thenMaskPassword() {
//        //given
////        final List<IDTAnonymizerConfiguration.IDTRegexPattern> maskPatterns = new ArrayList<>();
////        maskPatterns.add(new IDTAnonymizerConfiguration.IDTRegexPattern(Pattern
////                .compile("(password[\\w\\d]*?)(\"[\\s]*,[\\s]*\")(\\S+?)(\"[\\s]*:[\\s]*\")(\\S+?)(\".*?)", CASE_INSENSITIVE), "$1$2$3$4**Masked**$6"));
////        Mockito.when(IDTAnonymizerConfiguration.getMaskPatterns()).thenReturn(maskPatterns);
//
//        //when
//        final String input = "{\"name\" : \"password1\", \"value\" : \"abc123\"}";
//        final String anonymized = maskAnonymiser.anonymize(input);
//
//        //then
//        Assertions.assertEquals("{\"name\" : \"password1\", \"value\" : \"**Masked**\"}", anonymized);
//    }
//
//    @Test
//    void givenPatterns_whenAnonymize_thenMaskSsidPass() {
//        //given
////        final List<IDTAnonymizerConfiguration.IDTRegexPattern> maskPatterns = new ArrayList<>();
////        maskPatterns.add(new IDTAnonymizerConfiguration.IDTRegexPattern(Pattern
////                .compile("(ssid-pass)(\"[\\s]*,[\\s]*\")(\\S+?)(\"[\\s]*:[\\s]*\")(\\S+?)(\".*?)", CASE_INSENSITIVE), "$1$2$3$4**Masked**$6"));
////        maskPatterns.add(new IDTAnonymizerConfiguration.IDTRegexPattern(Pattern.compile("(ssid-pass)(\"[\\s]*:[\\s]*\")(\\S+?)(\".*?)", CASE_INSENSITIVE), "$1$2**Masked**$4"));
////        maskPatterns.add(new IDTAnonymizerConfiguration.IDTRegexPattern(Pattern.compile("(ssid-pass[^\"]*?)(=)(\\S+?)([,{\"})].*?)", CASE_INSENSITIVE), "$1$2**Masked**$4"));
////        Mockito.when(IDTAnonymizerConfiguration.getMaskPatterns()).thenReturn(maskPatterns);
//
//        //when
//        final String input1 = "{\"name\" : \"ssid-pass\", \"value\" : \"abc123\"}";
//        final String anonymized1 = maskAnonymiser.anonymize(input1);
//        Assertions.assertEquals("{\"name\" : \"ssid-pass\", \"value\" : \"**Masked**\"}", anonymized1);
//
//        final String input2 = "{\"ssid-pass\":\"abc123\"}";
//        final String anonymized2 = maskAnonymiser.anonymize(input2);
//        Assertions.assertEquals("{\"ssid-pass\":\"**Masked**\"}", anonymized2);
//
//        final String input3 = "FactorySettingsParameter(name=ssid-pass, value=ssid123)]";
//        final String anonymized3 = maskAnonymiser.anonymize(input3);
//        Assertions.assertEquals("FactorySettingsParameter(name=ssid-pass, value=**Masked**)]", anonymized3);
//    }
//}