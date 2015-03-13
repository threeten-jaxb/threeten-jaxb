package com.migesok.jaxb.adapter.javatime;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.junit.Before;
import org.junit.Test;

import static java.util.Objects.requireNonNull;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public abstract class AbstractToStringAdapterTest<T, A extends XmlAdapter<String, T>> {

    private final Class<A> adapterClass;
    protected A adapter;

    protected AbstractToStringAdapterTest(@Nonnull Class<A> adapterClass) {
        this.adapterClass = requireNonNull(adapterClass);
    }

    protected abstract T getNotNullValue();

    protected abstract String getNotValidStringValue();

    @Before
    public void setUp()
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        adapter = adapterClass.getConstructor().newInstance();
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
        T value = requireNonNull(getNotNullValue());
        String stringValue = adapter.marshal(value);
        T unmarshalledValue = adapter.unmarshal(stringValue);

        assertThat(unmarshalledValue, equalTo(value));
    }

    @Test(expected = RuntimeException.class)
    public void unmarshalNotValidValue() throws Exception {
        adapter.unmarshal(requireNonNull(getNotValidStringValue()));
    }
}
