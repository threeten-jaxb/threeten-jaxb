JAXB adapters for Java 8 Date and Time API (JSR-310) types
---------

[![Build Status](https://dev.azure.com/threeten-jaxb/threeten-jaxb/_apis/build/status/Check?branchName=master)](https://dev.azure.com/threeten-jaxb/threeten-jaxb/_build/latest?definitionId=3&branchName=master)

New Date and Time API introduced in Java 8 (aka JSR-310) is a big step forward comparing to what were available before in the JVM standard library. Sad thing that Java Architecture for XML Binding (JAXB) by default do not speak the new types. This library aimes to address the issue by providing a collection of [type adapters](http://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/adapters/XmlAdapter.html) to enable use of Java 8 Date and Time API types in JAXB bindings.

In serialization/deserialization logic the library follows the ISO 8601 standard formats wherever applicable.

Provided adapters:
* TemporalAccessorXmlAdapter - base class for an XML adapter mapping a `TemporalAccessor`'s subclass to `String` using given `DateTimeFormatter`

  Example:
  ```java
  public class DottedDateXmlAdapter extends TemporalAccessorXmlAdapter<LocalDate> {
      public DottedDateXmlAdapter() {
          super(DateTimeFormatter.ofPattern("dd.MM.yyyy"), LocalDate::from);
      }
  }
  ```
* DurationXmlAdapter
* InstantXmlAdapter
* LocalDateTimeXmlAdapter
* LocalDateXmlAdapter
* LocalTimeXmlAdapter
* OffsetDateTimeXmlAdapter
* OffsetTimeXmlAdapter
* PeriodXmlAdapter
* ZonedDateTimeXmlAdapter
* MonthDayXmlAdapter
* YearMonthXmlAdapter
* YearXmlAdapter
* ZoneIdXmlAdapter - for JSR-310's ZoneId and ZoneOffset

Source code is licensed under Apache 2.0 licence.

### Releases
Release 1.1.3 is the current latest release.
It depends on JDK 1.8 or later.

Available in the [Maven Central repository](https://search.maven.org/artifact/com.migesok/jaxb-java-time-adapters/1.1.3/jar)

### Support
Please use GitHub issues and Pull Requests for support.
