package com.hateoas.example.repository;

import com.hateoas.example.dto.response.ActorResponseDto;
import com.hateoas.example.dto.response.MovieResponseDto;
import com.hateoas.example.dto.response.ReviewResponseDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MovieRepository {

    public List<MovieResponseDto> getMovieList() {
        return List.of(
                new MovieResponseDto(1, "Interstellar", 8.6),
                new MovieResponseDto(2, "The Martian", 8.0)
        );
    }

    public Map<Integer, List<ActorResponseDto>> getMovieActorsMap() {
        List<ActorResponseDto> actors1 = List.of(
                new ActorResponseDto(1, "Matthew McConaughey"),
                new ActorResponseDto(2, "Anne Hathaway")
        );
        List<ActorResponseDto> actors2 = List.of(
                new ActorResponseDto(3, "Matt Damon"),
                new ActorResponseDto(4, "Jessica Chastain")
        );
        return Map.of(1, actors1, 2, actors2);
    }

    public Map<Integer, List<ReviewResponseDto>> getMovieReviewsMap() {
        List<ReviewResponseDto> reviews1 = List.of(
                new ReviewResponseDto("Aziz", "Excellent Movie", "Excellent Movie")
        );
        List<ReviewResponseDto> reviews2 = List.of(
                new ReviewResponseDto("Aziz", "Amazing Movie", "Amazing Movie")
        );
        return Map.of(1, reviews1, 2, reviews2);
    }

    public Map<Integer, List<String>> getMovieTagsMap() {
        List<String> tags1 = List.of("astronaut", "saving the world", "gravity");
        List<String> tags2 = List.of("astronaut", "nasa", "space habitat");
        return Map.of(1, tags1, 2, tags2);
    }

    public Map<Integer, List<String>> getMovieVideosMap() {
        List<String> videos1 = List.of("https://www.imdb.com/video/vi113423129/?ref_=tt_vi_i_1", "https://www.imdb.com/video/vi4112625689/?ref_=tt_vi_i_2");
        List<String> videos2 = List.of("https://www.imdb.com/video/vi2284039193/?ref_=tt_vi_i_2", "https://www.imdb.com/video/vi1586278169/?ref_=tt_vi_i_1");
        return Map.of(1, videos1, 2, videos2);
    }


    public Map<Integer, List<String>> getMovieGenresMap() {
        List<String> genres1 = List.of("Adventure", "Drama", "Sci-Fi");
        List<String> genres2 = List.of("Adventure", "Drama", "Sci-Fi");
        return Map.of(1, genres1, 2, genres2);
    }

}
