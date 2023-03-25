package com.driver;

import com.driver.Director;
import com.driver.Movie;
import com.driver.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    //check if movie already exist in List other wise add it in to List
    @Autowired
    MovieRepository mr;
    public  String addMovie(Movie movie) {

        return mr.addMovie(movie);
    }
    public  String addDirector(Director director) {
        return  mr.addDirector(director);
    }
    public String addPair(String movieName,String dirName){

        return mr.addPair(movieName,dirName);
    }
    public Movie getMovieByName(String name){
        return mr.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return mr.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){
       Director director = mr.getDirectorByName(name);
        System.out.println(director.getName());
       return mr.getListByDir(director);
    }
    public List<Movie> findAllMovies(){
        return mr.getListMovieList();
    }
    public String deleteDirectorByName(String name){
       Director d = mr.getDirectorByName(name);
       return mr.deleteDirector(d);
    }
    public String deleteAll(){
        return mr.deleteAll();
    }
}
