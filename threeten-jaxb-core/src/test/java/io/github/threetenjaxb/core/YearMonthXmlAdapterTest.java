package io.github.threetenjaxb.core;

import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

class YearMonthXmlAdapterTest extends AbstractXmlAdapterTest<String, YearMonth, YearMonthXmlAdapter> {

    private static final Map<String, YearMonth> STRING_YEAR_MONTH_MAP = new HashMap<>();

    static {
        STRING_YEAR_MONTH_MAP.put("2007-12", YearMonth.of(2007, Month.DECEMBER));
        STRING_YEAR_MONTH_MAP.put("-2007-12", YearMonth.of(-2007, Month.DECEMBER));
    }

    YearMonthXmlAdapterTest() {
        super(new YearMonthXmlAdapter(), STRING_YEAR_MONTH_MAP);
    }
}
