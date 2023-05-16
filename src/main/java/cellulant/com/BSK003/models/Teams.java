package cellulant.com.BSK003.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teams implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String teamName;
    private String teamDescription;
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Trainees> trainees;
}
