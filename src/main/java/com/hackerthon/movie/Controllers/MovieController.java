package com.hackerthon.movie.Controllers;

import com.hackerthon.movie.Entity.Movie;
import com.hackerthon.movie.Models.RegisterMovy;
import com.hackerthon.movie.service.MovieService;
import com.hackerthon.movie.util.MovieResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<MovieResponseWrapper> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        MovieResponseWrapper responseWrapper = new MovieResponseWrapper();
        responseWrapper.setData(movies);
        responseWrapper.setMessage("All Movies fetched successfully");
        responseWrapper.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieResponseWrapper> addMovie(@Valid @RequestBody RegisterMovy registerMovy) {

        Movie movie = movieService.addMovie(registerMovy);

        MovieResponseWrapper responseWrapper = new MovieResponseWrapper();
        responseWrapper.setData(movie);
        responseWrapper.setMessage("Movie added successfully");
        responseWrapper.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(responseWrapper,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<MovieResponseWrapper> deleteMovie(@RequestBody Movie movie){
        movieService.deleteMovie(movie);

        MovieResponseWrapper responseWrapper = new MovieResponseWrapper();
        responseWrapper.setData(movie);
        responseWrapper.setMessage("Movies deleted successfully");
        responseWrapper.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieResponseWrapper> editMovie(@RequestBody Movie movie){
        Movie movie1 = movieService.editMovie(movie);

        MovieResponseWrapper responseWrapper = new MovieResponseWrapper();
        responseWrapper.setData(movie1);
        responseWrapper.setMessage("Movie successfuy");
        responseWrapper.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
    }

    @GetMapping("/watched/{flag}")
    public ResponseEntity<MovieResponseWrapper> getMovies(@PathVariable("flag") String watch){

        List<Movie> movies = movieService.getMoviesByWatched(watch);

        MovieResponseWrapper responseWrapper = new MovieResponseWrapper();
        responseWrapper.setData(movies);
        responseWrapper.setMessage("Movies fetched successfully");
        responseWrapper.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
    }

}
