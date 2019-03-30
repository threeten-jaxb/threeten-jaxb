package io.github.threetenjaxb.core;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

class OffsetTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, OffsetTime, OffsetTimeXmlAdapter> {

    private static final Map<String, OffsetTime> STRING_OFFSET_TIME_MAP = new HashMap<>();

    static {
        STRING_OFFSET_TIME_MAP.put("10:15:30+01:00", OffsetTime
                .of(10, 15, 30, 0, ZoneOffset.ofHours(1))
        );
    }

    OffsetTimeXmlAdapterTest() {
        super(new OffsetTimeXmlAdapter(), STRING_OFFSET_TIME_MAP);
    }
}
