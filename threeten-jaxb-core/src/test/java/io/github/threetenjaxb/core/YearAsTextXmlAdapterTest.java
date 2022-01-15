package io.github.threetenjaxb.core;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

class YearAsTextXmlAdapterTest extends AbstractXmlAdapterTest<String, Year, YearAsTextXmlAdapter> {

    private static final Map<String, Year> STRING_YEAR_MAP = new HashMap<>();

    static {
        STRING_YEAR_MAP.put("2007", Year.of(2007));
    }

    YearAsTextXmlAdapterTest() {
        super(new YearAsTextXmlAdapter(), STRING_YEAR_MAP);
    }
}
