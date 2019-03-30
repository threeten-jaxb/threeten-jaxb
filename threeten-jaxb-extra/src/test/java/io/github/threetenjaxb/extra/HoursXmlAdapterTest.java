package io.github.threetenjaxb.extra;

import org.threeten.extra.Hours;

import java.util.HashMap;
import java.util.Map;

class HoursXmlAdapterTest extends AbstractXmlAdapterTest<String, Hours, HoursXmlAdapter> {

    private static final Map<String, Hours> STRING_HOURS_MAP = new HashMap<>();

    static {
        STRING_HOURS_MAP.put("PT72H", Hours.of(3 * 24));
        STRING_HOURS_MAP.put("PT4H", Hours.of(4));
        STRING_HOURS_MAP.put("PT0H", Hours.ZERO);
        STRING_HOURS_MAP.put("PT-4H", Hours.of(-4));
    }

    HoursXmlAdapterTest() {
        super(new HoursXmlAdapter(), STRING_HOURS_MAP);
    }
}
