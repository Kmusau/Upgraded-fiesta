package cellulant.com.BSK003.service;

import cellulant.com.BSK003.dto.apiResponse.MovieData;
import cellulant.com.BSK003.dto.apiResponse.Movies;
import cellulant.com.BSK003.dto.bskReponse.MovieResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    public List<MovieResponse> formulateMovieResponse() throws JsonProcessingException {
        List<MovieResponse> movieResponse = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "ea5879f90dmsha1cffba3cc4bfa0p13ccddjsnd0efe887f52e");
        headers.add("X-RapidAPI-Host", "imdb8.p.rapidapi.com");

        /**
        RequestEntity.HeadersBuilder<?> moviesList = RequestEntity.get("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr")
                .headers(headers);
        ResponseEntity<Movies> response = restTemplate.exchange(moviesList.build(), Movies.class);
        **/

        String url = "https://imdb8.p.rapidapi.com/auto-complete?q={variables}";
        String variables = "game%20of%20thr";
        HttpEntity<Object> request = new HttpEntity<>(headers);
        ResponseEntity<Movies> response = restTemplate.exchange(url, HttpMethod.GET, request, Movies.class, variables);

        log.info(String.valueOf(response.getStatusCode()));
        log.info("Movies response :: {}", new ObjectMapper().writeValueAsString(response.getBody()));
        MovieData[] movieData = response.getBody().getData();
        List<MovieData> movieList = Arrays.stream(movieData).toList();
        for (MovieData movieData1 :movieList) {
            MovieResponse movie = new MovieResponse();

            movie.setId(movieData1.getId());
            movie.setS(movieData1.getS());
            movie.setQ(movieData1.getQ());
            movie.setL(movieData1.getL());
            movie.setRank(movieData1.getRank());
            movie.setY(movieData1.getY());

            movieResponse.add(movie);
        }
        return movieResponse;
    }
}
