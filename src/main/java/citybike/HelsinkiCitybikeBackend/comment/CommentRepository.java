package citybike.HelsinkiCitybikeBackend.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
