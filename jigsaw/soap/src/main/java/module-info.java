module soap {
    exports com.gfi.lsos.training.jigsaw.soap;
    opens com.gfi.lsos.training.jigsaw.soap;
    opens schema;//forum.xsd from resources

    requires spring.ws.core;
    requires static lombok;
    requires spring.context;
    requires spring.boot;
    requires spring.xml;
    requires spring.core;
    requires java.xml.bind;
    requires org.slf4j;//??
    requires java.xml.soap;
    requires com.sun.xml.messaging.saaj;
    requires com.sun.xml.bind;
}
