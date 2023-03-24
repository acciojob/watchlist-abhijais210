package com.driver.controller;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    MovieService ms = new MovieService();
    @PostMapping("/add-movie")
    ResponseEntity<String> addMovie(@RequestBody Movie movie){
        ms.addMovie(movie);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PostMapping("/add-director")
    ResponseEntity<String> addDirector(@RequestBody Director director) {
        ms.addDirector(director);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PutMapping("/add-movie-director-pair")
    ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName")
                                                String dirName){
        ms.addPair(movieName,dirName);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @GetMapping("/get-movie-by-name/{name}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie m = ms.getMovieByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }
    @GetMapping("/get-director-by-name/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director d = ms.getDirectorByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String name){
        List<String> m = ms.getMoviesByDirectorName(name);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }
    @GetMapping("/get-all-movies")
    ResponseEntity<List<Movie>> findAllMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(ms.findAllMovies());
    }
    @DeleteMapping("/delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(String name){
        ms.deleteDirectorByName(name);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @DeleteMapping("/delete-all-directors")
    ResponseEntity<String> deleteAllDirectors(){
        ms.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
