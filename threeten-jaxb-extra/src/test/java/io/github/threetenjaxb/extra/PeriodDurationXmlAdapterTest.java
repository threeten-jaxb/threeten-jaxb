package io.github.threetenjaxb.extra;

import org.threeten.extra.PeriodDuration;

import java.time.Duration;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

class PeriodDurationXmlAdapterTest extends AbstractXmlAdapterTest<String, PeriodDuration, PeriodDurationXmlAdapter> {

    private static final Map<String, PeriodDuration> STRING_PERIOD_DURATION_MAP = new HashMap<>();

    static {
        STRING_PERIOD_DURATION_MAP.put("P2Y", PeriodDuration.of(Period.ofYears(2)));
        STRING_PERIOD_DURATION_MAP.put("P3M", PeriodDuration.of(Period.ofMonths(3)));
        STRING_PERIOD_DURATION_MAP.put("P28D", PeriodDuration.of(Period.ofWeeks(4)));
        STRING_PERIOD_DURATION_MAP.put("P5D", PeriodDuration.of(Period.ofDays(5)));
        STRING_PERIOD_DURATION_MAP.put("PT6H", PeriodDuration.of(Duration.ofHours(6)));
        STRING_PERIOD_DURATION_MAP.put("P1Y2M3D", PeriodDuration.of(Period.of(1, 2, 3)));
        STRING_PERIOD_DURATION_MAP.put("P1Y2M25DT8H", PeriodDuration.of(Period.of(1, 2, 25), Duration.ofHours(8)));
        STRING_PERIOD_DURATION_MAP.put("P-1Y2M", PeriodDuration.of(Period.of(-1, 2, 0)));
        STRING_PERIOD_DURATION_MAP.put("P-1Y-2M", PeriodDuration.of(Period.of(-1, -2, 0)));
    }

    PeriodDurationXmlAdapterTest() {
        super(new PeriodDurationXmlAdapter(), STRING_PERIOD_DURATION_MAP);
    }
}
