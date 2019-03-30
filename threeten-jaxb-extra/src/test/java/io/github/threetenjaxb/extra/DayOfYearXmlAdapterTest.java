package io.github.threetenjaxb.extra;

import org.threeten.extra.DayOfYear;

import java.util.HashMap;
import java.util.Map;

class DayOfYearXmlAdapterTest extends AbstractXmlAdapterTest<Integer, DayOfYear, DayOfYearXmlAdapter> {

    private static final Map<Integer, DayOfYear> STRING_DAY_OF_YEAR_MAP = new HashMap<>();

    static {
        STRING_DAY_OF_YEAR_MAP.put(51, DayOfYear.of(51));
    }

    DayOfYearXmlAdapterTest() {
        super(new DayOfYearXmlAdapter(), STRING_DAY_OF_YEAR_MAP);
    }
}
