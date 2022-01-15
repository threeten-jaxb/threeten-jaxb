package io.github.threetenjaxb.core;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping an integer as a string value
 * <p>
 * This adapter is suitable for {@code xsd:gDay} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 */
public class IntegerAsTextXmlAdapter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String stringValue) {
        return stringValue != null ? Integer.parseInt(stringValue) : null;
    }

    @Override
    public String marshal(Integer value) {
        return value != null ? value.toString() : null;
    }
}
