package cellulant.com.BSK003.repository;

import cellulant.com.BSK003.models.Courses;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends ReactiveCrudRepository<Courses, Integer> {
}
