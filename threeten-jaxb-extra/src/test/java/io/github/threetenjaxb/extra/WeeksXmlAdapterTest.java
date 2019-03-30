package io.github.threetenjaxb.extra;

import org.threeten.extra.Weeks;

import java.util.HashMap;
import java.util.Map;

class WeeksXmlAdapterTest extends AbstractXmlAdapterTest<String, Weeks, WeeksXmlAdapter> {

    private static final Map<String, Weeks> STRING_WEEKS_MAP = new HashMap<>();

    static {
        STRING_WEEKS_MAP.put("P12W", Weeks.of(12));
        STRING_WEEKS_MAP.put("P1W", Weeks.ONE);
        STRING_WEEKS_MAP.put("P0W", Weeks.ZERO);
        STRING_WEEKS_MAP.put("P-12W", Weeks.of(-12));
    }

    WeeksXmlAdapterTest() {
        super(new WeeksXmlAdapter(), STRING_WEEKS_MAP);
    }
}
