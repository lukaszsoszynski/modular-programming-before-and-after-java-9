package com.gfi.lsos.training.jigsaw.repositorysecondaryadapter;

import com.gfi.lsos.training.jigsaw.model.Forum;
import com.gfi.lsos.training.jigsaw.model.repository.ForumDao;
import com.gfi.lsos.training.jigsaw.repository.jpa.ForumRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor//spring cannot create proxy when
    //- jigsaw module system is used
    //- class is non public
    //- class has no args constructor
class ForumRepositoryToForumDaoSecondaryAdapter implements ForumDao {

    @Setter(onMethod = @__(@Autowired), value = AccessLevel.PACKAGE)
    private ForumRepository repository;

    @Override
    public Forum findForumByName(String forumName){
        return repository.getOne(forumName);
    }

}
