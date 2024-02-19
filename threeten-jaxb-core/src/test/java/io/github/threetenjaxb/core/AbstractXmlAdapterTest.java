package io.github.threetenjaxb.core;

import org.junit.jupiter.api.Test;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class AbstractXmlAdapterTest<ValueType, BoundType, XmlAdapterType extends XmlAdapter<ValueType, BoundType>> {

    final XmlAdapterType xmlAdapterType;
    final Map<ValueType, BoundType> valueBoundMap;

    AbstractXmlAdapterTest(final XmlAdapterType xmlAdapterType, final Map<ValueType, BoundType> valueBoundMap) {
        this.xmlAdapterType = Objects.requireNonNull(xmlAdapterType, "xmlAdapterType must not be null");
        this.valueBoundMap = Objects.requireNonNull(valueBoundMap, "valueBoundMap must not be null");
    }

    @Test
    void unmarshal() throws Exception {
        for (final Map.Entry<ValueType, BoundType> entry : valueBoundMap.entrySet()) {
            final ValueType value = entry.getKey();
            final BoundType bound = entry.getValue();
            assertEquals(bound, xmlAdapterType.unmarshal(value));
        }
    }

    @Test
    void marshal() throws Exception {
        for (final Map.Entry<ValueType, BoundType> entry : valueBoundMap.entrySet()) {
            final ValueType value = entry.getKey();
            final BoundType bound = entry.getValue();
            assertEquals(value, xmlAdapterType.marshal(bound));
        }
    }

    @Test
    void unmarshalNull() throws Exception {
        assertNull(xmlAdapterType.unmarshal(null), "XmlAdapters need to be defensive");
    }

    @Test
    void marshalNull() throws Exception {
        assertNull(xmlAdapterType.marshal(null), "XmlAdapters need to be defensive");
    }
}
