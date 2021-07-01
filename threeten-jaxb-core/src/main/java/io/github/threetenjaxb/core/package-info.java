/**
 * XmlAdapters for the {@link java.time} API.
 *
 * <p>These classes implement {@link jakarta.xml.bind.annotation.adapters.XmlAdapter} and can be used with the {@link jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter} annotation.
 *
 * <p><b>XJC Bindings Example</b>
 * <pre>{@code    <bindings xmlns="http://java.sun.com/xml/ns/jaxb" version="2.1"
 *             xmlns:xjc="http://java.sun.com/xml/ns/jaxb/xjc">
 *       <globalBindings>
 *           <xjc:javaType name="java.time.LocalDate" xmlType="xs:date" adapter="io.github.threetenjaxb.core.LocalDateXmlAdapter" />
 *           <xjc:javaType name="java.time.LocalDateTime" xmlType="xs:dateTime" adapter="io.github.threetenjaxb.core.LocalDateTimeXmlAdapter" />
 *           <xjc:javaType name="java.time.YearMonth" xmlType="xs:gYearMonth" adapter="io.github.threetenjaxb.core.YearMonthXmlAdapter" />
 *           <xjc:javaType name="java.time.Duration" xmlType="xs:duration" adapter="io.github.threetenjaxb.core.DurationXmlAdapter" />
 *       </globalBindings>
 *   </bindings>  }</pre>
 *
 * <p>Note: If you need support for <a href="https://www.w3.org/TR/xmlschema-2/#dateTime-timezones">XML Schema dateTime-timezones</a>, use {@link java.time.OffsetDateTime} instead of {@link java.time.LocalDateTime}.
 */
package io.github.threetenjaxb.core;
