package io.github.threetenjaxb.extra;

import org.threeten.extra.YearWeek;

import java.util.HashMap;
import java.util.Map;

class YearWeekXmlAdapterTest extends AbstractXmlAdapterTest<String, YearWeek, YearWeekXmlAdapter> {

    private static final Map<String, YearWeek> STRING_YEAR_WEEK_MAP = new HashMap<>();

    static {
        STRING_YEAR_WEEK_MAP.put("2007-W13", YearWeek.of(2007, 13));
    }

    YearWeekXmlAdapterTest() {
        super(new YearWeekXmlAdapter(), STRING_YEAR_WEEK_MAP);
    }
}
