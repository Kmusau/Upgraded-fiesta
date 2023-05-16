package cellulant.com.BSK003.service;

import cellulant.com.BSK003.models.Teams;
import cellulant.com.BSK003.repository.TeamsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeamsService {
    @Autowired
    TeamsRepository teamsRepo;

    @Cacheable("Teams")
    public List<Teams> getAllTeams() {
        log.info("Going to fetch teams... ");
        return teamsRepo.findAll();
    }

    @CacheEvict(value = "Teams", allEntries = true)
    public Teams addTeam(Teams team) {
        return teamsRepo.save(team);
    }

}
