package io.github.threetenjaxb.core.integration;

import io.github.threetenjaxb.core.DurationXmlAdapter;
import io.github.threetenjaxb.core.InstantXmlAdapter;
import io.github.threetenjaxb.core.IntegerAsTextXmlAdapter;
import io.github.threetenjaxb.core.LocalDateTimeXmlAdapter;
import io.github.threetenjaxb.core.LocalDateXmlAdapter;
import io.github.threetenjaxb.core.LocalTimeXmlAdapter;
import io.github.threetenjaxb.core.MonthAsTextXmlAdapter;
import io.github.threetenjaxb.core.MonthXmlAdapter;
import io.github.threetenjaxb.core.MonthDayXmlAdapter;
import io.github.threetenjaxb.core.OffsetDateTimeXmlAdapter;
import io.github.threetenjaxb.core.OffsetTimeXmlAdapter;
import io.github.threetenjaxb.core.PeriodXmlAdapter;
import io.github.threetenjaxb.core.YearAsTextXmlAdapter;
import io.github.threetenjaxb.core.YearMonthXmlAdapter;
import io.github.threetenjaxb.core.YearXmlAdapter;
import io.github.threetenjaxb.core.ZoneIdXmlAdapter;
import io.github.threetenjaxb.core.ZonedDateTimeXmlAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import org.junit.jupiter.api.Test;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
        expectedBean.dayTextified = 1;
        expectedBean.duration = Duration.ofDays(2).plusHours(3).plusMinutes(4);
        expectedBean.instant = LocalDateTime.of(2007, 12, 3, 10, 15, 30)
                .toInstant(ZoneOffset.UTC);
        expectedBean.localDateTime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
        expectedBean.localDate = LocalDate.of(2014, 12, 31);
        expectedBean.localTime = LocalTime.of(10, 15, 30);
        expectedBean.month = Month.DECEMBER;
        expectedBean.monthTextified = Month.DECEMBER;
        expectedBean.monthDay = MonthDay.of(Month.DECEMBER, 3);
        expectedBean.offsetDateTime = OffsetDateTime
                .of(2007, 12, 3, 10, 15, 30, 0, ZoneOffset.ofHours(1));
        expectedBean.offsetTime = OffsetTime
                .of(10, 15, 30, 0, ZoneOffset.ofHours(1));
        expectedBean.period = Period.of(1, 2, 25);
        expectedBean.year = Year.of(-2014);
        expectedBean.yearTextified = Year.of(-2014);
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
                () -> assertEquals(expectedBean.dayTextified, bean.dayTextified),
                () -> assertEquals(expectedBean.duration, bean.duration),
                () -> assertEquals(expectedBean.instant, bean.instant),
                () -> assertEquals(expectedBean.localDateTime, bean.localDateTime),
                () -> assertEquals(expectedBean.localDate, bean.localDate),
                () -> assertEquals(expectedBean.localTime, bean.localTime),
                () -> assertEquals(expectedBean.month, bean.month),
                () -> assertEquals(expectedBean.monthTextified, bean.monthTextified),
                () -> assertEquals(expectedBean.monthDay, bean.monthDay),
                () -> assertEquals(expectedBean.offsetDateTime, bean.offsetDateTime),
                () -> assertEquals(expectedBean.offsetTime, bean.offsetTime),
                () -> assertEquals(expectedBean.period, bean.period),
                () -> assertEquals(expectedBean.year, bean.year),
                () -> assertEquals(expectedBean.yearTextified, bean.yearTextified),
                () -> assertEquals(expectedBean.yearMonth, bean.yearMonth),
                () -> assertEquals(expectedBean.zoneId, bean.zoneId),
                () -> assertEquals(expectedBean.zoneOffset, bean.zoneOffset),
                () -> assertEquals(expectedBean.zonedDateTime, bean.zonedDateTime)
        );
    }

    @XmlRootElement
    static class Bean {

        @XmlJavaTypeAdapter(IntegerAsTextXmlAdapter.class)
        @XmlSchemaType(name = "gDay")
        @XmlElement(type = String.class)
        Integer dayTextified;

        @XmlJavaTypeAdapter(DurationXmlAdapter.class)
        @XmlSchemaType(name = "duration")
        Duration duration;

        @XmlJavaTypeAdapter(InstantXmlAdapter.class)
        Instant instant;

        @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
        LocalDateTime localDateTime;

        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        @XmlSchemaType(name = "date")
        LocalDate localDate;

        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        LocalTime localTime;

        @XmlJavaTypeAdapter(MonthXmlAdapter.class)
        Month month;

        @XmlJavaTypeAdapter(MonthAsTextXmlAdapter.class)
        @XmlSchemaType(name = "gMonth")
        @XmlElement(type = String.class)
        Month monthTextified;

        @XmlJavaTypeAdapter(MonthDayXmlAdapter.class)
        @XmlSchemaType(name = "gMonthDay")
        MonthDay monthDay;

        @XmlJavaTypeAdapter(OffsetDateTimeXmlAdapter.class)
        @XmlSchemaType(name = "dateTime")
        OffsetDateTime offsetDateTime;

        @XmlJavaTypeAdapter(OffsetTimeXmlAdapter.class)
        @XmlSchemaType(name = "time")
        OffsetTime offsetTime;

        @XmlJavaTypeAdapter(PeriodXmlAdapter.class)
        Period period;

        @XmlJavaTypeAdapter(YearXmlAdapter.class)
        Year year;

        @XmlJavaTypeAdapter(YearAsTextXmlAdapter.class)
        @XmlSchemaType(name = "gYear")
        @XmlElement(type = String.class)
        Year yearTextified;

        @XmlJavaTypeAdapter(YearMonthXmlAdapter.class)
        @XmlSchemaType(name = "gYearMonth")
        YearMonth yearMonth;

        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        ZoneId zoneId;

        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        ZoneOffset zoneOffset;

        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
        ZonedDateTime zonedDateTime;
    }
}
