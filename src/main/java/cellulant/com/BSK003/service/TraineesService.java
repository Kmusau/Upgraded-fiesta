package cellulant.com.BSK003.service;

import cellulant.com.BSK003.models.Courses;
import cellulant.com.BSK003.models.Teams;
import cellulant.com.BSK003.models.Trainees;
import cellulant.com.BSK003.repository.CoursesRepository;
import cellulant.com.BSK003.repository.TeamsRepository;
import cellulant.com.BSK003.repository.TraineesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineesService {
    @Autowired
    TraineesRepository traineesRepo;

    @Autowired
    TeamsRepository teamsRepo;

    @Autowired
    CoursesRepository coursesRepo;

    public List<Trainees> getAllTrainees() {
        return traineesRepo.findAll();
    }

    public Trainees addTrainee(Trainees trainee) {
        return traineesRepo.save(trainee);
    }

    public Trainees addTraineeToTeam(int traineeId, int teamId) {
        Optional<Trainees> trainee = traineesRepo.findById(traineeId);
        Optional<Teams> team = teamsRepo.findById(teamId);

        if (trainee.isPresent() && team.isPresent()) {
            trainee.get().setTeam(team.get());
            traineesRepo.save(trainee.get());
            return trainee.get();

        }

        return new Trainees();
    }

    public Trainees addCourseToATrainee(int traineeId, int courseId) {
        Optional<Trainees> trainee = traineesRepo.findById(traineeId);
        Optional<Courses> course = coursesRepo.findById(courseId);

        if (trainee.isPresent() && course.isPresent()) {
            trainee.get().takeCourse(course.get());
            traineesRepo.save(trainee.get());
            return trainee.get();
        }

        return new Trainees();
    }
}
