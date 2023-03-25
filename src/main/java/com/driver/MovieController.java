package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    MovieService ms = new MovieService();
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = ms.addMovie(movie);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = ms.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName")
                                                String dirName){
        String ans = ms.addPair(movieName,dirName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie m = ms.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
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
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(ms.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        String ans = ms.deleteDirectorByName(name);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String and  = ms.deleteAll();
        return new ResponseEntity<>(and,HttpStatus.OK);
    }
}
