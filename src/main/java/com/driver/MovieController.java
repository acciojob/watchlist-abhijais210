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
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        ms.addMovie(movie);
        return new ResponseEntity<>("Successfully Added",HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        ms.addDirector(director);
        return new ResponseEntity<>("Successfully director added",HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName")
                                                String dirName){
        ms.addPair(movieName,dirName);
        return new ResponseEntity<>("Pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie m = ms.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director d = ms.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> m = ms.getMoviesByDirectorName(director);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = ms.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        ms.deleteDirectorByName(name);
        return new ResponseEntity<>("deleted particular directory",HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        ms.deleteAll();
        return new ResponseEntity<>("deleted all directory",HttpStatus.OK);
    }
}