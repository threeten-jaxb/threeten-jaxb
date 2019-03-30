package io.github.threetenjaxb.extra;

import org.threeten.extra.Minutes;

import java.util.HashMap;
import java.util.Map;

class MinutesXmlAdapterTest extends AbstractXmlAdapterTest<String, Minutes, MinutesXmlAdapter> {

    private static final Map<String, Minutes> STRING_MINUTES_MAP = new HashMap<>();

    static {
        STRING_MINUTES_MAP.put("PT180M", Minutes.ofHours(3));
        STRING_MINUTES_MAP.put("PT8M", Minutes.of(8));
        STRING_MINUTES_MAP.put("PT0M", Minutes.ZERO);
        STRING_MINUTES_MAP.put("PT-8M", Minutes.of(-8));
    }

    MinutesXmlAdapterTest() {
        super(new MinutesXmlAdapter(), STRING_MINUTES_MAP);
    }
}
