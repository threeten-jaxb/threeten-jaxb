package io.github.threetenjaxb.core;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.Year;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Year} to ISO proleptic year string
 * <p>
 * Year string interpretation details:
 * <ul>
 * <li>{@link Year#parse(CharSequence)}</li>
 * <li>{@link Year#toString()}</li>
 * </ul>
 * <p>
 * This adapter is suitable for {@code xsd:gYear} types.
 *
 * @see XmlAdapter
 * @see Year
 */
public class YearAsTextXmlAdapter extends XmlAdapter<String, Year> {
    @Override
    public Year unmarshal(String isoYearString) {
        return isoYearString != null ? Year.parse(isoYearString) : null;
    }

    @Override
    public String marshal(Year year) {
        return year != null ? year.toString() : null;
    }
}
