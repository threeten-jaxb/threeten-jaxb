package io.github.threetenjaxb.extra;

import org.threeten.extra.LocalDateRange;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class LocalDateRangeXmlAdapterTest extends AbstractXmlAdapterTest<String, LocalDateRange, LocalDateRangeXmlAdapter> {

    private static final Map<String, LocalDateRange> STRING_LOCAL_DATE_RANGE_MAP = new HashMap<>();

    static {
        STRING_LOCAL_DATE_RANGE_MAP.put("2007-12-03/2007-12-04", LocalDateRange.of(
                LocalDate.of(2007, 12, 3),
                LocalDate.of(2007, 12, 4)
        ));
    }

    LocalDateRangeXmlAdapterTest() {
        super(new LocalDateRangeXmlAdapter(), STRING_LOCAL_DATE_RANGE_MAP);
    }
}
