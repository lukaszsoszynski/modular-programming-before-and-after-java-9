module amqp.secondary.adapter {
    opens com.gfi.lsos.training.jigsaw.notification.amqpsecondaryadapter;

    requires spring.context;
    requires model;
    requires amqp;
    requires spring.core;
    requires static lombok;
}