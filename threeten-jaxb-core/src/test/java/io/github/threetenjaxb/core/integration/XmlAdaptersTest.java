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
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlAdaptersTest {
    private final JAXBContext jaxbContext;
    private final Bean expectedBean;
    private final URL expectedMarshalledBean;

    XmlAdaptersTest() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Bean.class);

        final Bean expectedBean = new Bean();
        expectedBean.duration = Duration.ofDays(2).plusHours(3).plusMinutes(4);
        expectedBean.instant = LocalDateTime.of(2007, 12, 3, 10, 15, 30)
                .toInstant(ZoneOffset.UTC);
        expectedBean.localDateTime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
        expectedBean.localDate = LocalDate.of(2014, 12, 31);
        expectedBean.localTime = LocalTime.of(10, 15, 30);
        expectedBean.monthDay = MonthDay.of(Month.DECEMBER, 3);
        expectedBean.offsetDateTime = OffsetDateTime
                .of(2007, 12, 3, 10, 15, 30, 0, ZoneOffset.ofHours(1));
        expectedBean.offsetTime = OffsetTime
                .of(10, 15, 30, 0, ZoneOffset.ofHours(1));
        expectedBean.period = Period.of(1, 2, 25);
        expectedBean.year = Year.of(-2014);
        expectedBean.yearMonth = YearMonth.of(2014, 12);
        expectedBean.zoneId = ZoneId.of("America/New_York");
        expectedBean.zoneOffset = ZoneOffset.ofHoursMinutes(-12, 0);
        expectedBean.zonedDateTime = ZonedDateTime
                .of(2007, 12, 3, 10, 15, 30, 0, ZoneId.of("Europe/Paris"));
        this.expectedBean = expectedBean;

        this.expectedMarshalledBean = getClass().getResource("expectedBean.xml");
    }

    @Test
    void marshal() throws JAXBException, IOException, URISyntaxException {
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final Path marshalledPath = Files.createTempFile(null, null);
        marshaller.marshal(expectedBean, Files.newOutputStream(marshalledPath));
        final List<String> marshalledLines = Files.readAllLines(marshalledPath);
        final List<String> expectedLines = Files.readAllLines(Path.of(expectedMarshalledBean.toURI()));
        assertEquals(expectedLines, marshalledLines);
    }

    @Test
    void unmarshal() throws JAXBException {
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final Bean bean = (Bean) unmarshaller.unmarshal(expectedMarshalledBean);

        assertAll("bean",
                () -> assertEquals(expectedBean.duration, bean.duration),
                () -> assertEquals(expectedBean.instant, bean.instant),
                () -> assertEquals(expectedBean.localDateTime, bean.localDateTime),
                () -> assertEquals(expectedBean.localDate, bean.localDate),
                () -> assertEquals(expectedBean.localTime, bean.localTime),
                () -> assertEquals(expectedBean.monthDay, bean.monthDay),
                () -> assertEquals(expectedBean.offsetDateTime, bean.offsetDateTime),
                () -> assertEquals(expectedBean.offsetTime, bean.offsetTime),
                () -> assertEquals(expectedBean.period, bean.period),
                () -> assertEquals(expectedBean.year, bean.year),
                () -> assertEquals(expectedBean.yearMonth, bean.yearMonth),
                () -> assertEquals(expectedBean.zoneId, bean.zoneId),
                () -> assertEquals(expectedBean.zoneOffset, bean.zoneOffset),
                () -> assertEquals(expectedBean.zonedDateTime, bean.zonedDateTime)
        );
    }

    @XmlRootElement
    static class Bean {
        @XmlJavaTypeAdapter(DurationXmlAdapter.class)
        Duration duration;

        @XmlJavaTypeAdapter(InstantXmlAdapter.class)
        Instant instant;

        @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
        LocalDateTime localDateTime;

        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        LocalDate localDate;

        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        LocalTime localTime;

        @XmlJavaTypeAdapter(MonthDayXmlAdapter.class)
        MonthDay monthDay;

        @XmlJavaTypeAdapter(OffsetDateTimeXmlAdapter.class)
        OffsetDateTime offsetDateTime;

        @XmlJavaTypeAdapter(OffsetTimeXmlAdapter.class)
        OffsetTime offsetTime;

        @XmlJavaTypeAdapter(PeriodXmlAdapter.class)
        Period period;

        @XmlJavaTypeAdapter(YearXmlAdapter.class)
        Year year;

        @XmlJavaTypeAdapter(YearMonthXmlAdapter.class)
        YearMonth yearMonth;

        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        ZoneId zoneId;

        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        ZoneOffset zoneOffset;

        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
        ZonedDateTime zonedDateTime;
    }
}
