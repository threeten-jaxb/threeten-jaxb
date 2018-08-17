package com.migesok.jaxb.adapter.javatime;


import java.time.ZoneId;

class ZoneIdXmlAdapterTest extends AbstractToStringAdapterTest<ZoneId, ZoneIdXmlAdapter> {
    ZoneIdXmlAdapterTest() {
        super(ZoneIdXmlAdapter.class);
    }

    @Override
    ZoneId getNotNullValue() {
        return ZoneId.of("America/New_York");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}
