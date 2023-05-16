package cellulant.com.BSK003.dto.bskReponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieResponse implements Serializable {
    private String id;
    private String l;
    private String q;
    private int rank;
    private String s;
    private int y;
}
