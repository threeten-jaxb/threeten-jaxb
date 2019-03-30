package io.github.threetenjaxb.core;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class LocalDateXmlAdapterTest extends AbstractXmlAdapterTest<String, LocalDate, LocalDateXmlAdapter> {

    private final static Map<String, LocalDate> STRING_LOCAL_DATE_MAP = new HashMap<>();

    static {
        STRING_LOCAL_DATE_MAP.put("2007-12-03", LocalDate.of(2007, 12, 3));
    }

    LocalDateXmlAdapterTest() {
        super(new LocalDateXmlAdapter(), STRING_LOCAL_DATE_MAP);
    }
}
