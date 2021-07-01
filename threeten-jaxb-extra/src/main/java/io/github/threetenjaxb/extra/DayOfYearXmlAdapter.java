package io.github.threetenjaxb.extra;

import org.threeten.extra.DayOfYear;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link DayOfYear}
 *
 * <p>This {@link XmlAdapter} binds {@link DayOfYear} to its day-of-year value.
 */
public class DayOfYearXmlAdapter extends XmlAdapter<Integer, DayOfYear> {
    @Override
    public DayOfYear unmarshal(Integer dayOfYear) {
        return dayOfYear != null ? DayOfYear.of(dayOfYear) : null;
    }

    @Override
    public Integer marshal(DayOfYear dayOfYear) {
        return dayOfYear != null ? dayOfYear.getValue() : null;
    }
}
