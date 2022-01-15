package io.github.threetenjaxb.core;

import java.util.HashMap;
import java.util.Map;

class IntegerAsTextXmlAdapterTest extends AbstractXmlAdapterTest<String, Integer, IntegerAsTextXmlAdapter> {

    private static final Map<String, Integer> STRING_INTEGER_MAP = new HashMap<>();

    static {
        STRING_INTEGER_MAP.put("1", 1);
    }

    IntegerAsTextXmlAdapterTest() {
        super(new IntegerAsTextXmlAdapter(), STRING_INTEGER_MAP);
    }
}
