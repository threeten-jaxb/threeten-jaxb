package io.github.threetenjaxb.core;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

class PeriodXmlAdapterTest extends AbstractXmlAdapterTest<String, Period, PeriodXmlAdapter> {

    private static final Map<String, Period> STRING_PERIOD_MAP = new HashMap<>();

    static {
        STRING_PERIOD_MAP.put("P2Y", Period.ofYears(2));
        STRING_PERIOD_MAP.put("P3M", Period.ofMonths(3));
        STRING_PERIOD_MAP.put("P28D", Period.ofWeeks(4));
        STRING_PERIOD_MAP.put("P5D", Period.ofDays(5));
        STRING_PERIOD_MAP.put("P1Y2M3D", Period.of(1, 2, 3));
        STRING_PERIOD_MAP.put("P1Y2M25D", Period.of(1, 2, 25));
        STRING_PERIOD_MAP.put("P-1Y2M", Period.of(-1, 2, 0));
        STRING_PERIOD_MAP.put("P-1Y-2M", Period.of(-1, -2, 0));
    }

    PeriodXmlAdapterTest() {
        super(new PeriodXmlAdapter(), STRING_PERIOD_MAP);
    }
}
