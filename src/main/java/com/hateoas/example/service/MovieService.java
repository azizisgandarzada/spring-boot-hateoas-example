package com.hateoas.example.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.hateoas.example.controller.MovieController;
import com.hateoas.example.dto.response.ActorResponseDto;
import com.hateoas.example.dto.response.MovieResponseDto;
import com.hateoas.example.dto.response.ReviewResponseDto;
import com.hateoas.example.repository.MovieRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponseDto> getMovies() {
        return movieRepository.getMovieList().stream()
                .map(this::addLinks)
                .collect(Collectors.toList());
    }

    public MovieResponseDto getMovie(Integer id) {
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .map(this::addLinks)
                .orElseThrow();
    }

    public List<ActorResponseDto> getMovieActors(Integer id) {
        return movieRepository.getMovieActorsMap().get(id);

    }

    public List<ReviewResponseDto> getMovieReviews(Integer id) {
        return movieRepository.getMovieReviewsMap().get(id);
    }

    public List<String> getMovieVideos(Integer id) {
        return movieRepository.getMovieVideosMap().get(id);
    }

    public List<String> getMovieTags(Integer id) {
        return movieRepository.getMovieTagsMap().get(id);
    }

    public List<String> getMovieGenres(Integer id) {
        return movieRepository.getMovieGenresMap().get(id);
    }

    private MovieResponseDto addLinks(MovieResponseDto movie) {
        return movie.add(linkTo(methodOn(MovieController.class)
                        .getMovies())
                        .withSelfRel())
                .add(linkTo(methodOn(MovieController.class)
                        .getMovieActors(movie.getId()))
                        .withRel("actors"))
                .add(linkTo(methodOn(MovieController.class)
                        .getMovieReviews(movie.getId()))
                        .withRel("reviews"))
                .add(linkTo(methodOn(MovieController.class)
                        .getMovieTags(movie.getId()))
                        .withRel("tags"))
                .add(linkTo(methodOn(MovieController.class)
                        .getMovieVideos(movie.getId()))
                        .withRel("videos"))
                .add(linkTo(methodOn(MovieController.class)
                        .getMovieGenres(movie.getId()))
                        .withRel("genres"));
    }

}
