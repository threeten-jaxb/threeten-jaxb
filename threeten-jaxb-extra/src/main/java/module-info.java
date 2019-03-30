/**
 * threeten-extra-jaxb provides {@link javax.xml.bind.annotation.adapters.XmlAdapter}s for ThreeTen-Extra.
 */
module io.github.threetenjaxb.extra {
    requires java.xml.bind;
    requires org.threeten.extra;

    exports io.github.threetenjaxb.extra;
}
