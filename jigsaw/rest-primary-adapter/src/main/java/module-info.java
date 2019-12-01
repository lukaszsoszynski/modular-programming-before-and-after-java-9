module rest.primary.adapter {
    opens com.gfi.lsos.training.jigsaw.restprimaryport;

    requires spring.context;
    requires model;
    requires rest;
    requires spring.core;
    requires static lombok;
    requires spring.tx;
    requires spring.beans;
}