package cellulant.com.BSK003.service;

import cellulant.com.BSK003.models.Courses;
import cellulant.com.BSK003.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepo;

    public Flux<Courses> getCourses() {
        return coursesRepo.findAll();
    }

    public Mono<Courses> addCourse(Courses course) {
        return coursesRepo.save(course);
    }
}
