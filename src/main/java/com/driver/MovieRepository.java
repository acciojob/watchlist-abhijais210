package com.driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<Director,List<Movie>> hm;
    private HashMap<String,Movie> movieDb;
    private HashMap<String,Director> directorDb;

    public MovieRepository() {
        this.hm = new HashMap<Director,List<Movie>>();
        this.movieDb = new HashMap<String,Movie>();
        this.directorDb = new HashMap<String,Director>();
    }

    public List<Movie> getListMovieList(){
        return new ArrayList<>(movieDb.values());
    }

    public void addMovie(Movie m){
        String key = m.getName();
        movieDb.put(key,m);
    }
    public void addDirector(Director director){
        String key = director.getName();
        directorDb.put(key,director);
    }
    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name)){
            return directorDb.get(name);
        }
        return null;
    }
    public Movie getMovieByName(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    }
    public void addPair(String movieName,String directorName){
        if(directorDb.containsKey(directorName) && movieDb.containsKey(movieName)) {
            List<Movie> movieList = new ArrayList<>();
            Director director = getDirectorByName(directorName);
            Movie movie = getMovieByName(movieName);
            if(hm.containsKey(director)){
                movieList = hm.get(director);
            }
            movieList.add(movie);
            hm.put(director,movieList);
        }
    }
    public List<String> getListByDir(Director d){
        List<Movie> movieList = hm.get(d);
        List<String> list  = new ArrayList<>();
        for(Movie m: movieList ){
            System.out.println(m.getName());
            list.add(m.getName());
        }
        return list;
    }
    public void deleteDirector(Director director){
        List<Movie> movies = hm.get(director);
        for(Movie m : movies){
            movieDb.remove(m.getName());
        }
        hm.remove(director);
        directorDb.remove(director.getName());
    }
    public void deleteAll(){
        for(Director d : hm.keySet()) {
            deleteDirector(d);
        }
        hm.clear();
        directorDb.clear();
    }
}
