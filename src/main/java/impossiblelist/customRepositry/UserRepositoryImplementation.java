package impossiblelist.customRepositry;

import impossiblelist.model.User;
import impossiblelist.repositoryCustom.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImplementation implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<User> findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query, User.class);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findUsersByFilterCriteria(String filterCriteria) {
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(
                Criteria.where("username").regex(filterCriteria, "i"),
                Criteria.where("firstName").regex(filterCriteria, "i"),
                Criteria.where("lastName").regex(filterCriteria, "i")
        ));
        return mongoTemplate.find(query, User.class);

    }

}
