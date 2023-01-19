package cellulant.com.BSK003.controller;

import cellulant.com.BSK003.models.Courses;
import cellulant.com.BSK003.models.Teams;
import cellulant.com.BSK003.models.Trainees;
import cellulant.com.BSK003.service.CoursesService;
import cellulant.com.BSK003.service.TeamsService;
import cellulant.com.BSK003.service.TraineesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    TraineesService traineesService;

    @Autowired
    TeamsService teamsService;

    @Autowired
    CoursesService coursesService;

    @GetMapping("/trainees")
    public List<Trainees> getAllTrainees() {
        return traineesService.getAllTrainees();
    }

    @PostMapping("/trainees")
    public Trainees addTrainee(@RequestBody Trainees trainee) {
        return traineesService.addTrainee(trainee);
    }

    @PutMapping("/add/{traineeId}/team/{teamId}")
    public Trainees addTraineeToTeam(@PathVariable int traineeId, @PathVariable int teamId) {
        return traineesService.addTraineeToTeam(traineeId, teamId);
    }

    @PutMapping("/add/{traineeId}/course/{courseId}")
    public Trainees addCoursesToTrainee(@PathVariable int traineeId, @PathVariable int courseId) {
        return traineesService.addCourseToATrainee(traineeId, courseId);
    }

    @GetMapping("/teams")
    public List<Teams> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @PostMapping("/teams")
    public Teams addTeam(@RequestBody Teams team) {
        return teamsService.addTeam(team);
    }

    @GetMapping("/courses")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course) {
        return coursesService.addCourse(course);
    }

}
