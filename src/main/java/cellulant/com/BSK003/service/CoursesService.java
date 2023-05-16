package cellulant.com.BSK003.service;

import cellulant.com.BSK003.models.Courses;
import cellulant.com.BSK003.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepo;

    @Cacheable("Courses")
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    @CacheEvict(value = "Courses", allEntries = true)
    public Courses addCourse(Courses course) {
        return coursesRepo.save(course);
    }
}
