package io.github.threetenjaxb.core;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

class DurationXmlAdapterTest extends AbstractXmlAdapterTest<String, Duration, DurationXmlAdapter> {

    private static final Map<String, Duration> STRING_DURATION_MAP = new HashMap<>();

    static {
        STRING_DURATION_MAP.put("PT20.345S", Duration.ofSeconds(20).plusMillis(345));
        STRING_DURATION_MAP.put("PT15M", Duration.ofMinutes(15));
        STRING_DURATION_MAP.put("PT10H", Duration.ofHours(10));
        STRING_DURATION_MAP.put("PT48H", Duration.ofDays(2));
        STRING_DURATION_MAP.put("PT51H4M", Duration.ofDays(2).plusHours(3).plusMinutes(4));
        STRING_DURATION_MAP.put("PT-5H-57M", Duration.ofHours(-6).plusMinutes(3));
        STRING_DURATION_MAP.put("PT-6H-3M", Duration.ofHours(-6).minusMinutes(3));
        STRING_DURATION_MAP.put("PT5H57M", Duration.ofHours(6).minusMinutes(3));
    }

    DurationXmlAdapterTest() {
        super(new DurationXmlAdapter(), STRING_DURATION_MAP);
    }
}
