package com.gfi.lsos.training.jigsaw.model.repository;

import com.gfi.lsos.training.jigsaw.model.stereotype.InputPort;
import com.gfi.lsos.training.jigsaw.model.Forum;

@InputPort
public interface ForumDao {

    Forum findForumByName(String forumName);
}
