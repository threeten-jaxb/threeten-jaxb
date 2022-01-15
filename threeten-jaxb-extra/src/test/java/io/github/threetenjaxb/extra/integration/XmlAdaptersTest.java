package io.github.threetenjaxb.extra.integration;

import io.github.threetenjaxb.extra.DayOfMonthAsTextXmlAdapter;
import io.github.threetenjaxb.extra.DayOfMonthXmlAdapter;
import io.github.threetenjaxb.extra.DayOfYearXmlAdapter;
import io.github.threetenjaxb.extra.DaysXmlAdapter;
import io.github.threetenjaxb.extra.HoursXmlAdapter;
import io.github.threetenjaxb.extra.IntervalXmlAdapter;
import io.github.threetenjaxb.extra.LocalDateRangeXmlAdapter;
import io.github.threetenjaxb.extra.MinutesXmlAdapter;
import io.github.threetenjaxb.extra.MonthsXmlAdapter;
import io.github.threetenjaxb.extra.PeriodDurationXmlAdapter;
import io.github.threetenjaxb.extra.SecondsXmlAdapter;
import io.github.threetenjaxb.extra.WeeksXmlAdapter;
import io.github.threetenjaxb.extra.YearQuarterXmlAdapter;
import io.github.threetenjaxb.extra.YearWeekXmlAdapter;
import io.github.threetenjaxb.extra.YearsXmlAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import org.junit.jupiter.api.Test;
import org.threeten.extra.DayOfMonth;
import org.threeten.extra.DayOfYear;
import org.threeten.extra.Days;
import org.threeten.extra.Hours;
import org.threeten.extra.Interval;
import org.threeten.extra.LocalDateRange;
import org.threeten.extra.Minutes;
import org.threeten.extra.Months;
import org.threeten.extra.PeriodDuration;
import org.threeten.extra.Quarter;
import org.threeten.extra.Seconds;
import org.threeten.extra.Weeks;
import org.threeten.extra.YearQuarter;
import org.threeten.extra.YearWeek;
import org.threeten.extra.Years;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlAdaptersTest {

    private final JAXBContext jaxbContext;
    private final Bean expectedBean;
    private final URL expectedMarshalledBean;

    XmlAdaptersTest() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(Bean.class);

        final Bean expectedBean = new Bean();
        expectedBean.dayOfMonth = DayOfMonth.of(21);
        expectedBean.dayOfMonthTextified = DayOfMonth.of(21);
        expectedBean.dayOfYear = DayOfYear.of(51);
        expectedBean.days = Days.of(12);
        expectedBean.hours = Hours.of(4);
        expectedBean.interval = Interval.of(
                LocalDateTime.of(2007, 12, 3, 10, 15, 30)
                        .toInstant(ZoneOffset.UTC),
                LocalDateTime.of(2007, 12, 4, 10, 15, 30)
                        .toInstant(ZoneOffset.UTC)
        );
        expectedBean.localDateRange = LocalDateRange.of(
                LocalDate.of(2007, 12, 3),
                LocalDate.of(2007, 12, 4)
        );
        expectedBean.minutes = Minutes.of(8);
        expectedBean.months = Months.of(12);
        expectedBean.periodDuration = PeriodDuration.of(Period.of(1, 2, 25), Duration.ofHours(8));
        expectedBean.seconds = Seconds.of(8);
        expectedBean.weeks = Weeks.of(12);
        expectedBean.yearQuarter = YearQuarter.of(2017, Quarter.Q2);
        expectedBean.years = Years.of(12);
        expectedBean.yearWeek = YearWeek.of(2015, 13);
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
        final Bean unmarshalled = (Bean) unmarshaller.unmarshal(expectedMarshalledBean);
        assertAll("bean",
                () -> assertEquals(expectedBean.dayOfMonth, unmarshalled.dayOfMonth),
                () -> assertEquals(expectedBean.dayOfMonthTextified, unmarshalled.dayOfMonthTextified),
                () -> assertEquals(expectedBean.dayOfYear, unmarshalled.dayOfYear),
                () -> assertEquals(expectedBean.days, unmarshalled.days),
                () -> assertEquals(expectedBean.hours, unmarshalled.hours),
                () -> assertEquals(expectedBean.interval, unmarshalled.interval),
                () -> assertEquals(expectedBean.localDateRange, unmarshalled.localDateRange),
                () -> assertEquals(expectedBean.minutes, unmarshalled.minutes),
                () -> assertEquals(expectedBean.months, unmarshalled.months),
                () -> assertEquals(expectedBean.periodDuration, unmarshalled.periodDuration),
                () -> assertEquals(expectedBean.seconds, unmarshalled.seconds),
                () -> assertEquals(expectedBean.weeks, unmarshalled.weeks),
                () -> assertEquals(expectedBean.yearQuarter, unmarshalled.yearQuarter),
                () -> assertEquals(expectedBean.years, unmarshalled.years),
                () -> assertEquals(expectedBean.yearWeek, unmarshalled.yearWeek)
        );
    }

    @XmlRootElement
    static class Bean {
        @XmlJavaTypeAdapter(DayOfMonthXmlAdapter.class)
        DayOfMonth dayOfMonth;

        @XmlJavaTypeAdapter(DayOfMonthAsTextXmlAdapter.class)
        @XmlSchemaType(name = "gDay")
        @XmlElement(type = String.class)
        DayOfMonth dayOfMonthTextified;

        @XmlJavaTypeAdapter(DayOfYearXmlAdapter.class)
        DayOfYear dayOfYear;

        @XmlJavaTypeAdapter(DaysXmlAdapter.class)
        Days days;

        @XmlJavaTypeAdapter(HoursXmlAdapter.class)
        Hours hours;

        @XmlJavaTypeAdapter(IntervalXmlAdapter.class)
        Interval interval;

        @XmlJavaTypeAdapter(LocalDateRangeXmlAdapter.class)
        LocalDateRange localDateRange;

        @XmlJavaTypeAdapter(MinutesXmlAdapter.class)
        Minutes minutes;

        @XmlJavaTypeAdapter(MonthsXmlAdapter.class)
        Months months;

        @XmlJavaTypeAdapter(PeriodDurationXmlAdapter.class)
        PeriodDuration periodDuration;

        @XmlJavaTypeAdapter(SecondsXmlAdapter.class)
        Seconds seconds;

        @XmlJavaTypeAdapter(WeeksXmlAdapter.class)
        Weeks weeks;

        @XmlJavaTypeAdapter(YearQuarterXmlAdapter.class)
        YearQuarter yearQuarter;

        @XmlJavaTypeAdapter(YearsXmlAdapter.class)
        Years years;

        @XmlJavaTypeAdapter(YearWeekXmlAdapter.class)
        YearWeek yearWeek;
    }
}
