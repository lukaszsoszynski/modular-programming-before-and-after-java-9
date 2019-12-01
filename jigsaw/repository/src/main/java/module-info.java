module repository {
    opens com.gfi.lsos.training.jigsaw.repository.jpa;

    requires model;
    requires spring.data.jpa;
    requires spring.context;
    exports com.gfi.lsos.training.jigsaw.repository.jpa;
}