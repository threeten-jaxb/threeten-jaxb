package io.github.threetenjaxb.extra;

import org.junit.jupiter.api.Test;
import org.threeten.extra.OffsetDate;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OffsetDateXmlAdapterTest extends AbstractXmlAdapterTest<String, OffsetDate, OffsetDateXmlAdapter> {

    private static final Map<String, OffsetDate> STRING_OFFSET_DATE_MAP = new HashMap<>();
    private static final OffsetDateXmlAdapter ADAPTER = new OffsetDateXmlAdapter();

    static {
        STRING_OFFSET_DATE_MAP.put("2020-01-15+01:00", OffsetDate.of(2020, 1, 15, ZoneOffset.ofHours(1)));
        STRING_OFFSET_DATE_MAP.put("2020-01-15Z", OffsetDate.of(2020, 1, 15, ZoneOffset.UTC));
    }

    OffsetDateXmlAdapterTest() {
        super(new OffsetDateXmlAdapter(), STRING_OFFSET_DATE_MAP);
    }

    @Test
    void canParseDateWithoutOffset() throws Exception {
        assertTrue(ADAPTER.unmarshal("2020-01-15").isEqual(OffsetDate.of(2020, 1, 15, ZoneOffset.UTC)));
        assertEquals("2020-01-15Z", ADAPTER.marshal(OffsetDate.of(2020, 1, 15, ZoneOffset.UTC)));
    }
}
