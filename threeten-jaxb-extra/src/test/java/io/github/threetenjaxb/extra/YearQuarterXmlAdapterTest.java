package io.github.threetenjaxb.extra;

import org.threeten.extra.Quarter;
import org.threeten.extra.YearQuarter;

import java.util.HashMap;
import java.util.Map;

class YearQuarterXmlAdapterTest extends AbstractXmlAdapterTest<String, YearQuarter, YearQuarterXmlAdapter> {

    private static final Map<String, YearQuarter> STRING_YEAR_QUARTER_MAP = new HashMap<>();

    static {
        STRING_YEAR_QUARTER_MAP.put("2007-Q2", YearQuarter.of(2007, Quarter.Q2));
    }

    YearQuarterXmlAdapterTest() {
        super(new YearQuarterXmlAdapter(), STRING_YEAR_QUARTER_MAP);
    }
}
