module amqp {
    exports com.gfi.lsos.training.jigsaw.notification.amqp;
    opens com.gfi.lsos.training.jigsaw.notification.amqp;

    requires static lombok;
    requires org.slf4j;
    requires spring.context;
    requires spring.amqp;
    requires spring.rabbit;
    requires spring.core;
    requires spring.tx;
}