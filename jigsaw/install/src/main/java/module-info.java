module install {
    opens com.gfi.lsos.training.jigsaw.install;

    requires model;
    requires soap.primary.adapter;
    requires rest.primary.adapter;
    requires amqp.secondary.adapter;
    requires repository.secondary.adapter;

    requires spring.boot.autoconfigure;
    requires spring.context;
    requires repository;
    requires spring.boot;
    requires java.sql;//???
    requires net.bytebuddy;//??
}