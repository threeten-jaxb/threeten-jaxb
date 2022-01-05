package io.github.threetenjaxb.extra;

import org.threeten.extra.DayOfMonth;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link DayOfMonth}
 *
 * <p>This {@link XmlAdapter} binds {@link DayOfMonth} to its day-of-month
 * value.
 * <p>
 * Be aware that using this adapter will yield {@code null} when unmarshalling
 * {@code xsd:gDay} types. Use {@link DayOfMonthAsTextXmlAdapter} instead.
 */
public class DayOfMonthXmlAdapter extends XmlAdapter<Integer, DayOfMonth> {
    @Override
    public DayOfMonth unmarshal(Integer integer) {
        return integer != null ? DayOfMonth.of(integer) : null;
    }

    @Override
    public Integer marshal(DayOfMonth dayOfMonth) {
        return dayOfMonth != null ? dayOfMonth.getValue() : null;
    }
}
