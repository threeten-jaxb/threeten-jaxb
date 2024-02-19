package io.github.threetenjaxb.core;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LenientOffsetTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, OffsetTime, LenientOffsetTimeXmlAdapter> {

    private static final Map<String, OffsetTime> STRING_OFFSET_TIME_MAP = new HashMap<>();

    static {
        STRING_OFFSET_TIME_MAP.put("10:15:30+01:00", OffsetTime
                .of(10, 15, 30, 0, ZoneOffset.ofHours(1))
        );
        STRING_OFFSET_TIME_MAP.put("10:15:30.00000005+01:00", OffsetTime
                .of(10, 15, 30, 50, ZoneOffset.ofHours(1))
        );
    }

    LenientOffsetTimeXmlAdapterTest() {
        super(new LenientOffsetTimeXmlAdapter(), STRING_OFFSET_TIME_MAP);
    }

    @Test
    void unmarshalLocalTime() {
        OffsetTime offsetTime = OffsetTime.of(10, 15, 30, 0, ZoneOffset.UTC);
        assertEquals(offsetTime, xmlAdapterType.unmarshal("10:15:30"));
    }

    @Test
    void unmarshalUTC() {
        OffsetTime offsetTime = OffsetTime.of(10, 15, 30, 0, ZoneOffset.UTC);
        assertEquals(offsetTime, xmlAdapterType.unmarshal("10:15:30Z"));
    }
}
