package cellulant.com.BSK003.service;

import cellulant.com.BSK003.models.Teams;
import cellulant.com.BSK003.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {
    @Autowired
    TeamsRepository teamsRepo;

    public List<Teams> getAllTeams() {
        return teamsRepo.findAll();
    }

    public Teams addTeam(Teams team) {
        return teamsRepo.save(team);
    }

}
