package cellulant.com.BSK003.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int traineeId;
    private String name;
    private String developerType;

    @JoinColumn(name = "team_id", referencedColumnName = "teamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teams team;
    @ManyToMany()
    @JoinTable(name = "trainees_courses", joinColumns = @JoinColumn(name = "trainee_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> courses;

    public void takeCourse(Courses course) {
        courses.add(course);
    }
}
