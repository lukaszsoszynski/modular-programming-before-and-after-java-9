package com.gfi.lsos.training.jigsaw.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfi.lsos.training.jigsaw.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, String> {
}
