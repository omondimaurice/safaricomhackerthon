package com.hackerthon.movie.service;

import com.hackerthon.movie.Entity.Movie;
import com.hackerthon.movie.Models.RegisterMovy;
import com.hackerthon.movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    public Movie addMovie(RegisterMovy registerMovy) {

        Movie movie = new Movie();
        movie.setCreatedOn(new Date(System.currentTimeMillis()));
        movie.setTitle(registerMovy.getTitle());
        movie.setContent(registerMovy.getContent());
        movie.setDescription(registerMovy.getDescription());
        if (movie.getRating()>= 1  && movie.getRating() <= 5) {
            movie.setRating(registerMovy.getRating());
        }
        movie.setRecommendation(registerMovy.getRecommendation());
        movie.setWatched(registerMovy.getWatched());

        return movieRepository.save(movie);
    }

    public void deleteMovie(Movie movie) {
         movieRepository.delete(movie);
    }

    public Movie editMovie(Movie movie) {

        movie.setUpDatedOn(new Date(System.currentTimeMillis()));
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByWatched(String watch) {
        List<Movie> movies;

        Optional<List<Movie>> opt = movieRepository.findMoviesByWatched(watch);

        if (opt.isPresent()) {
            movies = opt.get();

            return movies;
        }else {
            return null;
        }

    }
}
