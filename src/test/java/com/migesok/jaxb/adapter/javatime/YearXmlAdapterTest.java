package com.migesok.jaxb.adapter.javatime;

import java.time.DateTimeException;
import java.time.Year;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class YearXmlAdapterTest {
    private YearXmlAdapter adapter;

    @Before
    public void setUp() {
        adapter = new YearXmlAdapter();
    }

    @Test
    public void marshallNull() throws Exception {
        assertNull(adapter.marshal(null));
    }

    @Test
    public void unmarshalNull() throws Exception {
        assertNull(adapter.unmarshal(null));
    }

    @Test
    public void marshallNotNullValue() throws Exception {
        Year value = Year.of(-2014);
        Integer marshaledValue = adapter.marshal(value);
        Year unmarshalledValue = adapter.unmarshal(marshaledValue);

        assertThat(unmarshalledValue, equalTo(value));
    }

    @Test(expected = DateTimeException.class)
    public void unmarshalNotValidValue() throws Exception {
        adapter.unmarshal(Integer.MIN_VALUE);
    }
}
