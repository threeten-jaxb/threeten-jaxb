package io.github.threetenjaxb.core;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

class YearXmlAdapterTest extends AbstractXmlAdapterTest<Integer, Year, YearXmlAdapter> {

    private static final Map<Integer, Year> INTEGER_YEAR_MAP = new HashMap<>();

    static {
        INTEGER_YEAR_MAP.put(2007, Year.of(2007));
    }

    YearXmlAdapterTest() {
        super(new YearXmlAdapter(), INTEGER_YEAR_MAP);
    }
}
