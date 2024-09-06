# threeten-jaxb: XmlAdapters for [ThreeTen](https://www.threeten.org/)

[![CI](https://github.com/threeten-jaxb/threeten-jaxb/actions/workflows/ci.yml/badge.svg)](https://github.com/threeten-jaxb/threeten-jaxb/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.threeten-jaxb/threeten-jaxb-core.svg)](https://search.maven.org/search?q=g:io.github.threeten-jaxb)
[![javadoc](https://javadoc.io/badge2/io.github.threeten-jaxb/threeten-jaxb-core/javadoc.svg)](https://javadoc.io/doc/io.github.threeten-jaxb)
[![GitHub](https://img.shields.io/github/license/threeten-jaxb/threeten-jaxb.svg)](https://opensource.org/licenses/Apache-2.0)

The new Date and Time API introduced in Java 8 (aka JSR-310) was a big step forward
compared to what was available before in the JVM standard library.
Sadly, Jakarta XML Binding (JAXB) does not speak the new types by default.

This library aims to address this issue by providing a collection of
[type adapters](https://jakarta.ee/specifications/xml-binding/4.0/apidocs/jakarta.xml.bind/jakarta/xml/bind/annotation/adapters/xmladapter)
to enable use of the Java 8 Date and Time API types in JAXB bindings.

In serialization/deserialization logic the library follows the ISO 8601
standard formats wherever applicable.

Version 2 of this library conforms to the new [Jakarta XML Binding](https://jakarta.ee/specifications/xml-binding/4.0/).
If you are still using the old “javax” JAXB, please refer to [release 1.2](https://github.com/threeten-jaxb/threeten-jaxb/tree/v1.2).
