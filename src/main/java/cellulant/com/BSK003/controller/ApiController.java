package cellulant.com.BSK003.controller;

import cellulant.com.BSK003.models.Courses;
import cellulant.com.BSK003.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/courses")
    public Flux<Courses> getAllCourses() {
        return coursesService.getCourses();
    }

    @PostMapping("/courses")
    public Mono<Courses> addCourse(@RequestBody Courses course) {
        return coursesService.addCourse(course);
    }

}
