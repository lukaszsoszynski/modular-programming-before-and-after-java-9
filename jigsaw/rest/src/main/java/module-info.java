module rest {
    exports com.gfi.lsos.training.jigsaw.rest.dto;
    exports com.gfi.lsos.training.jigsaw.rest;
    opens com.gfi.lsos.training.jigsaw.rest.dto;
    opens com.gfi.lsos.training.jigsaw.rest;

    requires static lombok;
    requires java.desktop;//???
    requires spring.web;
    requires spring.beans;
}