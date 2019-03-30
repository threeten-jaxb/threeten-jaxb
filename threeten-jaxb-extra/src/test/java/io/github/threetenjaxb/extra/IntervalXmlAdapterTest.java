package io.github.threetenjaxb.extra;

import org.threeten.extra.Interval;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

class IntervalXmlAdapterTest extends AbstractXmlAdapterTest<String, Interval, IntervalXmlAdapter> {

    private static final Map<String, Interval> STRING_INTERVAL_MAP = new HashMap<>();

    static {
        STRING_INTERVAL_MAP.put("2007-12-03T10:15:30Z/2007-12-04T10:15:30Z", Interval.of(
                LocalDateTime.of(2007, 12, 3, 10, 15, 30).toInstant(ZoneOffset.UTC),
                LocalDateTime.of(2007, 12, 4, 10, 15, 30).toInstant(ZoneOffset.UTC)
        ));
    }

    IntervalXmlAdapterTest() {
        super(new IntervalXmlAdapter(), STRING_INTERVAL_MAP);
    }
}
