# threeten-jaxb: XmlAdapters for [ThreeTen](https://www.threeten.org/)

[![Build Status](https://dev.azure.com/threeten-jaxb/threeten-jaxb/_apis/build/status/Check?branchName=master)](https://dev.azure.com/threeten-jaxb/threeten-jaxb/_build/latest?definitionId=3&branchName=master)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.threeten-jaxb/threeten-jaxb-core.svg)](https://search.maven.org/search?q=g:io.github.threeten-jaxb)
[![GitHub](https://img.shields.io/github/license/threeten-jaxb/threeten-jaxb.svg)](https://opensource.org/licenses/Apache-2.0)

New Date and Time API introduced in Java 8 (aka JSR-310) is a big step forward
comparing to what were available before in the JVM standard library. Sad thing
that Java Architecture for XML Binding (JAXB) by default do not speak the new
types. This library aims to address the issue by providing a collection of
[type adapters](http://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/adapters/XmlAdapter.html)
to enable use of Java 8 Date and Time API types in JAXB bindings.

In serialization/deserialization logic the library follows the ISO 8601
standard formats wherever applicable.

## Documentation

The Javadoc is available [here](https://threeten-jaxb.github.io/threeten-jaxb-core/javadoc/).

## Support
Please use GitHub issues and Pull Requests for support.
