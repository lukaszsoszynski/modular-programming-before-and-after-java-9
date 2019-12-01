module soap.primary.adapter {
    opens com.gfi.lsos.training.jigsaw.soapprimaryadapter.converter;
    opens com.gfi.lsos.training.jigsaw.soapprimaryadapter;

    requires soap;
    requires spring.context;
    requires static lombok;
    requires model;
    requires spring.core;
    requires spring.tx;
    requires spring.beans;
}