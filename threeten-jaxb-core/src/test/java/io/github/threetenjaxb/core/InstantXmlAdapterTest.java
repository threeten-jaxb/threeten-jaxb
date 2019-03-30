package io.github.threetenjaxb.core;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

class InstantXmlAdapterTest extends AbstractXmlAdapterTest<String, Instant, InstantXmlAdapter> {

    private static final Map<String, Instant> STRING_INSTANT_MAP = new HashMap<>();

    static {
        STRING_INSTANT_MAP.put("2007-12-03T10:15:30Z", LocalDateTime
                .of(2007, 12, 3, 10, 15, 30).toInstant(ZoneOffset.UTC)
        );
    }

    InstantXmlAdapterTest() {
        super(new InstantXmlAdapter(), STRING_INSTANT_MAP);
    }
}
