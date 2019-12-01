module repository.secondary.adapter {
    opens com.gfi.lsos.training.jigsaw.repositorysecondaryadapter;

    requires static lombok;
    requires spring.context;
    requires repository;
    requires model;
    requires spring.beans;
}