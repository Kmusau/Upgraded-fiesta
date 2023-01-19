package cellulant.com.BSK003.repository;

import cellulant.com.BSK003.models.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {
}
