package io.github.threetenjaxb.core;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

class ZonedDateTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, ZonedDateTime, ZonedDateTimeXmlAdapter> {

    private static final Map<String, ZonedDateTime> STRING_ZONED_DATE_TIME_MAP = new HashMap<>();

    static {
        STRING_ZONED_DATE_TIME_MAP.put("2007-12-03T10:15:30+01:00[Europe/Paris]",
                ZonedDateTime.of(2007, 12, 3, 10, 15, 30, 0,
                        ZoneId.of("Europe/Paris"))
        );
    }

    ZonedDateTimeXmlAdapterTest() {
        super(new ZonedDateTimeXmlAdapter(), STRING_ZONED_DATE_TIME_MAP);
    }
}
