package io.github.threetenjaxb.extra;

import org.threeten.extra.Years;

import java.util.HashMap;
import java.util.Map;

class YearsXmlAdapterTest extends AbstractXmlAdapterTest<String, Years, YearsXmlAdapter> {

    private static final Map<String, Years> STRING_YEARS_MAP = new HashMap<>();

    static {
        STRING_YEARS_MAP.put("P12Y", Years.of(12));
        STRING_YEARS_MAP.put("P1Y", Years.ONE);
        STRING_YEARS_MAP.put("P0Y", Years.ZERO);
        STRING_YEARS_MAP.put("P-12Y", Years.of(-12));
    }

    YearsXmlAdapterTest() {
        super(new YearsXmlAdapter(), STRING_YEARS_MAP);
    }
}
