package io.github.threetenjaxb.core.integration;

import io.github.threetenjaxb.core.DurationXmlAdapter;
import io.github.threetenjaxb.core.InstantXmlAdapter;
import io.github.threetenjaxb.core.LocalDateTimeXmlAdapter;
import io.github.threetenjaxb.core.LocalDateXmlAdapter;
import io.github.threetenjaxb.core.LocalTimeXmlAdapter;
import io.github.threetenjaxb.core.MonthDayXmlAdapter;
import io.github.threetenjaxb.core.OffsetDateTimeXmlAdapter;
import io.github.threetenjaxb.core.OffsetTimeXmlAdapter;
import io.github.threetenjaxb.core.PeriodXmlAdapter;
import io.github.threetenjaxb.core.YearMonthXmlAdapter;
import io.github.threetenjaxb.core.YearXmlAdapter;
import io.github.threetenjaxb.core.ZoneIdXmlAdapter;
import io.github.threetenjaxb.core.ZonedDateTimeXmlAdapter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JaxbAdaptersTest {
    private JAXBContext jaxbContext;

    @BeforeEach
    public void setUp() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Bean.class);
    }

    @Test
    public void unmarshalBean() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setEventHandler(new DefaultValidationEventHandler());
        Bean bean = (Bean) unmarshaller.unmarshal(getClass().getResourceAsStream("/bean.xml"));

        assertNotNull(bean);
        assertEquals(bean.duration, Duration.parse("P2DT3H4M"));
        assertEquals(bean.duration, Duration.parse("P2DT3H4M"));
        assertEquals(bean.period, Period.parse("P1Y2M3W4D"));
        assertEquals(bean.instant, Instant.parse("2007-12-03T10:15:30.00Z"));
        assertEquals(bean.zonedDateTime, ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"));
        assertEquals(bean.localDate, LocalDate.parse("2014-12-31+01:00",DateTimeFormatter.ISO_DATE));
        assertEquals(bean.localDate2, LocalDate.parse("2014-12-31"));
        assertEquals(bean.localDateTime, LocalDateTime.parse("2007-12-03T10:15:30"));
        assertEquals(bean.localTime, LocalTime.parse("10:15:30"));
        assertEquals(bean.offsetDateTime, OffsetDateTime.parse("2007-12-03T10:15:30+01:00"));
        assertEquals(bean.offsetTime, OffsetTime.parse("10:15:30+01:00"));
        assertEquals(bean.month, Month.FEBRUARY);
        assertEquals(bean.dayOfWeek, DayOfWeek.WEDNESDAY);
        assertEquals(bean.year, Year.of(-2014));
        assertEquals(bean.yearMonth, YearMonth.of(2014, 12));
        assertEquals(bean.monthDay, MonthDay.of(Month.DECEMBER, 3));
        assertEquals(bean.zoneOffset, ZoneOffset.ofHoursMinutes(-12, 0));
        assertEquals(bean.zoneId, ZoneId.of("America/New_York"));
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
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        public LocalDate localDate2;
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
        @XmlElement
        public Month month;
        @XmlElement
        public DayOfWeek dayOfWeek;
        @XmlElement
        @XmlJavaTypeAdapter(YearXmlAdapter.class)
        public Year year;
        @XmlElement
        @XmlJavaTypeAdapter(YearMonthXmlAdapter.class)
        public YearMonth yearMonth;
        @XmlElement
        @XmlJavaTypeAdapter(MonthDayXmlAdapter.class)
        public MonthDay monthDay;
        @XmlElement
        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        public ZoneOffset zoneOffset;
        @XmlElement
        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        public ZoneId zoneId;
    }
}
