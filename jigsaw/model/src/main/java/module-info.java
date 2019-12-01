module model {
    exports com.gfi.lsos.training.jigsaw.model.stereotype;
    exports com.gfi.lsos.training.jigsaw.model.notification;
    exports com.gfi.lsos.training.jigsaw.model;
    exports com.gfi.lsos.training.jigsaw.model.repository;

    opens com.gfi.lsos.training.jigsaw.model;

    requires static lombok;
    requires org.hibernate.orm.core;//due to byte code generation...
}