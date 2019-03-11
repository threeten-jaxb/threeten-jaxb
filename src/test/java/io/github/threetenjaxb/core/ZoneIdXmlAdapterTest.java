package io.github.threetenjaxb.core;


import java.time.ZoneId;

public class ZoneIdXmlAdapterTest extends AbstractToStringAdapterTest<ZoneId, ZoneIdXmlAdapter> {
    public ZoneIdXmlAdapterTest() {
        super(ZoneIdXmlAdapter.class);
    }

    @Override
    protected ZoneId getNotNullValue() {
        return ZoneId.of("America/New_York");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}
