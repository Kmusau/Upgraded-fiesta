package cellulant.com.BSK003.repository;

import cellulant.com.BSK003.models.Trainees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineesRepository extends JpaRepository<Trainees, Integer> {
}
