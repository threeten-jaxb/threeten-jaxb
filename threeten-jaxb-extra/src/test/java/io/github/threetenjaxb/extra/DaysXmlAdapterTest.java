package io.github.threetenjaxb.extra;

import org.threeten.extra.Days;

import java.util.HashMap;
import java.util.Map;

class DaysXmlAdapterTest extends AbstractXmlAdapterTest<String, Days, DaysXmlAdapter> {

    private static final Map<String, Days> STRING_DAYS_MAP = new HashMap<>();

    static {
        STRING_DAYS_MAP.put("P12D", Days.of(12));
        STRING_DAYS_MAP.put("P1D", Days.ONE);
        STRING_DAYS_MAP.put("P0D", Days.ZERO);
        STRING_DAYS_MAP.put("P-12D", Days.of(-12));
    }

    DaysXmlAdapterTest() {
        super(new DaysXmlAdapter(), STRING_DAYS_MAP);
    }
}
