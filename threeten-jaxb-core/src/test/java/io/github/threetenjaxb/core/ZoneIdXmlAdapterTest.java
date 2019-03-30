package io.github.threetenjaxb.core;


import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

class ZoneIdXmlAdapterTest extends AbstractXmlAdapterTest<String, ZoneId, ZoneIdXmlAdapter> {

    private static final Map<String, ZoneId> STRING_ZONE_ID_MAP = new HashMap<>();

    static {
        STRING_ZONE_ID_MAP.put("Europe/Paris", ZoneId.of("Europe/Paris"));
        STRING_ZONE_ID_MAP.put("America/New_York", ZoneId.of("America/New_York"));
    }

    ZoneIdXmlAdapterTest() {
        super(new ZoneIdXmlAdapter(), STRING_ZONE_ID_MAP);
    }
}
