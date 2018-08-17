package com.migesok.jaxb.adapter.javatime;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class AbstractToStringAdapterTest<T, A extends XmlAdapter<String, T>> {

    private final Class<A> adapterClass;
    private A adapter;

    AbstractToStringAdapterTest(@Nonnull Class<A> adapterClass) {
        this.adapterClass = requireNonNull(adapterClass);
    }

    abstract T getNotNullValue();

    abstract String getNotValidStringValue();

    @BeforeEach
    void setUp()
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        adapter = adapterClass.getConstructor().newInstance();
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
        T value = requireNonNull(getNotNullValue());
        String stringValue = adapter.marshal(value);
        T unmarshalledValue = adapter.unmarshal(stringValue);

        assertEquals(unmarshalledValue, value);
    }

    @Test
    void unmarshalNotValidValue() throws Exception {
        assertThrows(RuntimeException.class, () -> adapter.unmarshal(requireNonNull(getNotValidStringValue())));
    }
}
