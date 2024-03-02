package io.github.threetenjaxb.core;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

class OffsetDateTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, OffsetDateTime, OffsetDateTimeXmlAdapter> {

    private static final Map<String, OffsetDateTime> STRING_OFFSET_DATE_TIME_MAP = new HashMap<>();

    static {
        STRING_OFFSET_DATE_TIME_MAP.put("2007-12-03T10:15:30+01:00",
                OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0,
                        ZoneOffset.ofHours(1))
        );
        STRING_OFFSET_DATE_TIME_MAP.put("2007-12-03T10:15:30Z",
                OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0,
                        ZoneOffset.UTC)
        );
        STRING_OFFSET_DATE_TIME_MAP.put("2007-12-03T10:15:30.00000005+01:00",
                OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 50,
                        ZoneOffset.ofHours(1))
        );
    }

    OffsetDateTimeXmlAdapterTest() {
        super(new OffsetDateTimeXmlAdapter(), STRING_OFFSET_DATE_TIME_MAP);
    }
}
