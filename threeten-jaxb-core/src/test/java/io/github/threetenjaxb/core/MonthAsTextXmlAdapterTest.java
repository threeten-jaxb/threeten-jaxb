package io.github.threetenjaxb.core;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

class MonthAsTextXmlAdapterTest extends AbstractXmlAdapterTest<String, Month, MonthAsTextXmlAdapter> {

    private static final Map<String, Month> STRING_MONTH_MAP = new HashMap<>();

    static {
        STRING_MONTH_MAP.put("1", Month.of(1));
    }

    MonthAsTextXmlAdapterTest() {
        super(new MonthAsTextXmlAdapter(), STRING_MONTH_MAP);
    }
}
