package cellulant.com.BSK003.dto.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movies {
    @JsonProperty("d")
    private MovieData[] data;
    @JsonProperty("q")
    private String queryString;
    private int v;
}
