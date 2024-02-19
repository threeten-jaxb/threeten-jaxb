package io.github.threetenjaxb.core;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LenientOffsetDateTimeXmlAdapterTest extends AbstractXmlAdapterTest<String, OffsetDateTime, LenientOffsetDateTimeXmlAdapter> {

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

    LenientOffsetDateTimeXmlAdapterTest() {
        super(new LenientOffsetDateTimeXmlAdapter(), STRING_OFFSET_DATE_TIME_MAP);
    }

    @Test
    void unmarshalLocalDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0,
                ZoneOffset.UTC);
        assertEquals(offsetDateTime, xmlAdapterType.unmarshal("2007-12-03T10:15:30"));
    }

    @Test
    void unmarshalUTC() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0,
                ZoneOffset.UTC);
        assertEquals(offsetDateTime, xmlAdapterType.unmarshal("2007-12-03T10:15:30Z"));
    }
}
