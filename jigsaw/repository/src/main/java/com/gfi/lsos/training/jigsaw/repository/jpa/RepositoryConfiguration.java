package com.gfi.lsos.training.jigsaw.repository.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryConfiguration.class)
public class RepositoryConfiguration {

}
