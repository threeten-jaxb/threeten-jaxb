package com.migesok.jaxb.adapter.javatime.integration;

import com.migesok.jaxb.adapter.javatime.*;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class JaxbAdaptersTest {
    private JAXBContext jaxbContext;

    @Before
    public void setUp() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Bean.class);
    }

    @Test
    public void unmarshalBean() throws JAXBException {
        Bean bean = (Bean) jaxbContext.createUnmarshaller().unmarshal(getClass().getResourceAsStream("/bean.xml"));

        assertNotNull(bean);
        assertThat(bean.duration, equalTo(Duration.parse("P2DT3H4M")));
        assertThat(bean.period, equalTo(Period.parse("P1Y2M3W4D")));
        assertThat(bean.instant, equalTo(Instant.parse("2007-12-03T10:15:30.00Z")));
        assertThat(bean.zonedDateTime, equalTo(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]")));
        assertThat(bean.localDate, equalTo(LocalDate.parse("2014-12-31")));
        assertThat(bean.localDateTime, equalTo(LocalDateTime.parse("2007-12-03T10:15:30")));
        assertThat(bean.localTime, equalTo(LocalTime.parse("10:15:30")));
        assertThat(bean.offsetDateTime, equalTo(OffsetDateTime.parse("2007-12-03T10:15:30+01:00")));
        assertThat(bean.offsetTime, equalTo(OffsetTime.parse("10:15:30+01:00")));
    }

    @XmlRootElement
    public static class Bean {
        @XmlElement
        @XmlJavaTypeAdapter(DurationXmlAdapter.class)
        public Duration duration;
        @XmlElement
        @XmlJavaTypeAdapter(PeriodXmlAdapter.class)
        public Period period;
        @XmlElement
        @XmlJavaTypeAdapter(InstantXmlAdapter.class)
        public Instant instant;
        @XmlElement
        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
        public ZonedDateTime zonedDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        public LocalDate localDate;
        @XmlElement
        @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
        public LocalDateTime localDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        public LocalTime localTime;
        @XmlElement
        @XmlJavaTypeAdapter(OffsetDateTimeXmlAdapter.class)
        public OffsetDateTime offsetDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(OffsetTimeXmlAdapter.class)
        public OffsetTime offsetTime;
    }
}
