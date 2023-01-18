package cellulant.com.BSK003.dto.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieData {
    @JsonProperty("i")
    private ImageData image;
    private String id;
    private String l;
    private String q;
    private String qid;
    private int rank;
    private String s;
    private int y;
    private String yr;
}
