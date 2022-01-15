package io.github.threetenjaxb.core;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.Month;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Month} to ISO proleptic month string
 * <p>
 * Month string interpretation details (transformed to a string):
 * <ul>
 * <li>{@link java.time.Month#of(int)}</li>
 * <li>{@link java.time.Month#getValue()}</li>
 * </ul>
 * <p>
 * This adapter is suitable for {@code xsd:gMonth} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Month
 */
public class MonthAsTextXmlAdapter extends XmlAdapter<String, Month> {
    @Override
    public Month unmarshal(String stringValue) {
        return stringValue != null ? Month.of(Integer.parseInt(stringValue)) : null;
    }

    @Override
    public String marshal(Month value) {
        return value != null ? Integer.toString(value.getValue()) : null;
    }
}
