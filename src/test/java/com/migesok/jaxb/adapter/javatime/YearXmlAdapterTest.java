package com.migesok.jaxb.adapter.javatime;

import java.time.DateTimeException;
import java.time.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YearXmlAdapterTest {
    private YearXmlAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new YearXmlAdapter();
    }

    @Test
    void marshallNull() throws Exception {
        assertNull(adapter.marshal(null));
    }

    @Test
    void unmarshalNull() throws Exception {
        assertNull(adapter.unmarshal(null));
    }

    @Test
    void marshallNotNullValue() throws Exception {
        Year value = Year.of(-2014);
        Integer marshaledValue = adapter.marshal(value);
        Year unmarshalledValue = adapter.unmarshal(marshaledValue);

        assertEquals(unmarshalledValue, value);
    }

    @Test
    void unmarshalNotValidValue() throws Exception {
        assertThrows(DateTimeException.class, () -> adapter.unmarshal(Integer.MIN_VALUE));
    }
}
