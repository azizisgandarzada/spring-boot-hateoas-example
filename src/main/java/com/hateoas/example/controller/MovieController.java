package com.hateoas.example.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.hateoas.example.dto.response.ActorResponseDto;
import com.hateoas.example.dto.response.MovieResponseDto;
import com.hateoas.example.dto.response.ReviewResponseDto;
import com.hateoas.example.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getMovies() {
        return ok(movieService.getMovies());
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieResponseDto> getMovie(@PathVariable Integer id) {
        return ok(movieService.getMovie(id));
    }

    @GetMapping("{id}/actors")
    public ResponseEntity<List<ActorResponseDto>> getMovieActors(@PathVariable Integer id) {
        return ok(movieService.getMovieActors(id));
    }

    @GetMapping("{id}/reviews")
    public ResponseEntity<List<ReviewResponseDto>> getMovieReviews(@PathVariable Integer id) {
        return ok(movieService.getMovieReviews(id));
    }

    @GetMapping("{id}/videos")
    public ResponseEntity<List<String>> getMovieVideos(@PathVariable Integer id) {
        return ok(movieService.getMovieVideos(id));
    }

    @GetMapping("{id}/tags")
    public ResponseEntity<List<String>> getMovieTags(@PathVariable Integer id) {
        return ok(movieService.getMovieTags(id));
    }

    @GetMapping("{id}/genres")
    public ResponseEntity<List<String>> getMovieGenres(@PathVariable Integer id) {
        return ok(movieService.getMovieGenres(id));
    }

}
