package cellulant.com.BSK003.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("courses")
public class Courses implements Serializable {
    @Id
    @Column("course_id")
    private int courseId;
    @Column("course_name")
    private String courseName;
    @Column("course_description")
    private String courseDescription;
}
