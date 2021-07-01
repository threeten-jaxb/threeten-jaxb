/**
 * threeten-extra-jaxb provides {@link jakarta.xml.bind.annotation.adapters.XmlAdapter}s for ThreeTen-Extra.
 */
module io.github.threetenjaxb.extra {
    requires jakarta.xml.bind;
    requires org.threeten.extra;

    exports io.github.threetenjaxb.extra;
}
