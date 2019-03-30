package io.github.threetenjaxb.extra;

import org.threeten.extra.Months;

import java.util.HashMap;
import java.util.Map;

class MonthsXmlAdapterTest extends AbstractXmlAdapterTest<String, Months, MonthsXmlAdapter> {

    private static final Map<String, Months> STRING_MONTHS_MAP = new HashMap<>();

    static {
        STRING_MONTHS_MAP.put("P36M", Months.ofYears(3));
        STRING_MONTHS_MAP.put("P12M", Months.of(12));
        STRING_MONTHS_MAP.put("P1M", Months.ONE);
        STRING_MONTHS_MAP.put("P0M", Months.ZERO);
        STRING_MONTHS_MAP.put("P-12M", Months.of(-12));
    }

    MonthsXmlAdapterTest() {
        super(new MonthsXmlAdapter(), STRING_MONTHS_MAP);
    }
}
