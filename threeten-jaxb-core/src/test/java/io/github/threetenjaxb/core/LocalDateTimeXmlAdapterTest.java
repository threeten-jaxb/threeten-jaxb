package io.github.threetenjaxb.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class LocalDateTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, LocalDateTime, LocalDateTimeXmlAdapter> {

    private final static Map<String, LocalDateTime> STRING_LOCAL_DATE_TIME_MAP = new HashMap<>();

    static {
        STRING_LOCAL_DATE_TIME_MAP.put("2007-12-03T10:15:30", LocalDateTime
                .of(2007, 12, 3, 10, 15, 30)
        );
    }

    LocalDateTimeXmlAdapterTest() {
        super(new LocalDateTimeXmlAdapter(), STRING_LOCAL_DATE_TIME_MAP);
    }
}
