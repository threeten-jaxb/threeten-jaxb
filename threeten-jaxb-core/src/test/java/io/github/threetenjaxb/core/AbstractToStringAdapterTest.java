package io.github.threetenjaxb.core;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractToStringAdapterTest<T, A extends XmlAdapter<String, T>> {

    private final Class<A> adapterClass;
    protected A adapter;

    protected AbstractToStringAdapterTest(@Nonnull Class<A> adapterClass) {
        this.adapterClass = requireNonNull(adapterClass);
    }

    protected abstract T getNotNullValue();

    protected abstract String getNotValidStringValue();

    @BeforeEach
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

        assertEquals(unmarshalledValue, value);
    }

    @Test
    public void unmarshalNotValidValue() throws Exception {
        assertThrows(RuntimeException.class, () -> adapter.unmarshal(requireNonNull(getNotValidStringValue())));
    }
}
