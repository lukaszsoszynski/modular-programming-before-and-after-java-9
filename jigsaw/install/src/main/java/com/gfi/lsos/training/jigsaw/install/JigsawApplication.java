package com.gfi.lsos.training.jigsaw.install;

import com.gfi.lsos.training.jigsaw.model.stereotype.OutputPort;
import com.gfi.lsos.training.jigsaw.repository.jpa.RepositoryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.gfi.lsos.training.jigsaw",
		includeFilters = @ComponentScan.Filter(type = ANNOTATION, classes = OutputPort.class))
@Import(RepositoryConfiguration.class)
public class JigsawApplication {

	//on java 11 run with options --add-modules java.instrument,java.xml.bind -Djavax.xml.soap.SAAJMetaFactory=com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl
	public static void main(String[] args) {
		SpringApplication.run(JigsawApplication.class, args);
	}

}
