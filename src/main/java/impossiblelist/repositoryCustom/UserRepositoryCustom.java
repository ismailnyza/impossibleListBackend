package impossiblelist.repositoryCustom;

import impossiblelist.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

    Optional<User> findByUsername(String username);

    List<User> findUsersByFilterCriteria(String filterCriteria);

}
