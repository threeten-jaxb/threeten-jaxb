JAXB adapters for Java 8 Date and Time API (JSR-310) types
---------

New Date and Time API introduced in Java 8 (aka JSR-310) is a big step forward comparing to what were available before in the JVM standard library. Sad thing that Java Architecture for XML Binding (JAXB) by default do not speak the new types. This library aimes to address the issue by providing a collection of type adapters to enable use of Java 8 Date and Time API types in JAXB bindings.

In serialization/deserialization logic the library follows the ISO 8601 standard formats wherever applicable.

Provided adapters:
* TemporalAccessorXmlAdapter - base class for an XML adapter mapping a `TemporalAccessor`'s subclass to `String` using given `DateTimeFormatter`

  Example:
  ```java
  class DottedDateXmlAdapter extends TemporalAccessorXmlAdapter<LocalDate> {
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

Source code is licensed under Apache 2.0 licence.

### Releases
Coming soon.

### Support
Please use GitHub issues and Pull Requests for support.
