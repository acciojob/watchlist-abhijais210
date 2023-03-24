package com.driver.service;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    //check if movie already exist in List other wise add it in to List
    MovieRepository mr = new MovieRepository();
    public  void addMovie(Movie movie) {
        mr.addMovie(movie);
    }
    public  void addDirector(Director director) {
        mr.addDirector(director);
    }
    public void addPair(String movieName,String dirName){

        mr.addPair(mr.getMovieByName(movieName),mr.getDirectorByName(dirName));
    }
    public Movie getMovieByName(String name){
        return mr.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return mr.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){
       Director director = mr.getDirectorByName(name);
       return mr.getListByDir(director);
    }
    public List<Movie> findAllMovies(){
        return mr.getListMovieList();
    }
    public void deleteDirectorByName(String name){
       Director d = mr.getDirectorByName(name);
       mr.deleteDirector(d);
    }
    public void deleteAll(){
        mr.deleteAll();
    }
}
