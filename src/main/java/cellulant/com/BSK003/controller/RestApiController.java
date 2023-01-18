package cellulant.com.BSK003.controller;

import cellulant.com.BSK003.dto.reponse.MovieResponse;
import cellulant.com.BSK003.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestApiController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/movies")
    public List<MovieResponse> booksList() throws JsonProcessingException {
        return movieService.formulateMovieResponse();
    }
}
