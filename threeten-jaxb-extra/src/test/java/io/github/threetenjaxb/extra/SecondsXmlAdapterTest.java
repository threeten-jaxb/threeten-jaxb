package io.github.threetenjaxb.extra;

import org.threeten.extra.Seconds;

import java.util.HashMap;
import java.util.Map;

class SecondsXmlAdapterTest extends AbstractXmlAdapterTest<String, Seconds, SecondsXmlAdapter> {

    private static final Map<String, Seconds> STRING_SECONDS_MAP = new HashMap<>();

    static {
        STRING_SECONDS_MAP.put("PT10800S", Seconds.ofHours(3));
        STRING_SECONDS_MAP.put("PT180S", Seconds.ofMinutes(3));
        STRING_SECONDS_MAP.put("PT8S", Seconds.of(8));
        STRING_SECONDS_MAP.put("PT0S", Seconds.ZERO);
        STRING_SECONDS_MAP.put("PT-8S", Seconds.of(-8));
    }

    SecondsXmlAdapterTest() {
        super(new SecondsXmlAdapter(), STRING_SECONDS_MAP);
    }
}
