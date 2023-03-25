package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService ms;
    @PostMapping("/movies/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        ms.addMovie(movie);
        return new ResponseEntity<>("Successfully Added",HttpStatus.CREATED);
    }
    @PostMapping("/movies/addDirector")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        ms.addDirector(director);
        return new ResponseEntity<>("Successfully director added",HttpStatus.CREATED);
    }
    @PutMapping("/movies/addMovieDirectorPair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName")
                                                String dirName){
        ms.addPair(movieName,dirName);
        return new ResponseEntity<>("Pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/movies/getMovieByName/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie m = ms.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    @GetMapping("/movies/getDirectorByName/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director d = ms.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }
    @GetMapping("/movies/getMoviesByDirectorName/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> m = ms.getMoviesByDirectorName(director);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/movies/findAllMovies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> movies = ms.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/deleteDirectorByName")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        ms.deleteDirectorByName(name);
        return new ResponseEntity<>("deleted particular directory",HttpStatus.OK);
    }
    @DeleteMapping("/movies/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors(){
        ms.deleteAll();
        return new ResponseEntity<>("deleted all directory",HttpStatus.OK);
    }
}