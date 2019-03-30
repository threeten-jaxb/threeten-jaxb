package io.github.threetenjaxb.core;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class LocalTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, LocalTime, LocalTimeXmlAdapter> {

    private static final Map<String, LocalTime> STRING_LOCAL_TIME_MAP = new HashMap<>();

    static {
        STRING_LOCAL_TIME_MAP.put("10:15:30", LocalTime.of(10, 15, 30));
    }

    LocalTimeXmlAdapterTest() {
        super(new LocalTimeXmlAdapter(), STRING_LOCAL_TIME_MAP);
    }
}
