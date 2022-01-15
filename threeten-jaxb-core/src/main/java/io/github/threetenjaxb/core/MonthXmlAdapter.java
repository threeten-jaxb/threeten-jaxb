package io.github.threetenjaxb.core;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.Month;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Month} to ISO proleptic month number
 * <p>
 * Month number interpretation details:
 * <ul>
 * <li>{@link java.time.Month#of(int)}</li>
 * <li>{@link java.time.Month#getValue()}</li>
 * </ul>
 * <p>
 * Be aware that using this adapter will yield {@code null} when unmarshalling
 * {@code xsd:gMonth} types. Use {@link MonthAsTextXmlAdapter} instead.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Month
 */
public class MonthXmlAdapter extends XmlAdapter<Integer, Month> {
    @Override
    public Month unmarshal(Integer intValue) {
        return intValue != null ? Month.of(intValue) : null;
    }

    @Override
    public Integer marshal(Month value) {
        return value != null ? value.getValue() : null;
    }
}
