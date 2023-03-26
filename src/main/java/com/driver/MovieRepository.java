package com.driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<String,List<String>> hm;
    private HashMap<String,Movie> movieDb;
    private HashMap<String,Director> directorDb;

    public MovieRepository() {
        this.hm = new HashMap<String,List<String>>();
        this.movieDb = new HashMap<String,Movie>();
        this.directorDb = new HashMap<String,Director>();
    }

    public List<String> getListMovieList(){
        return new ArrayList<>(movieDb.keySet());
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
            List<String> movieList = new ArrayList<>();
            if(hm.containsKey(directorName)){
                movieList = hm.get(directorName);
            }
            movieList.add(movieName);
            hm.put(directorName,movieList);
        }
    }
    public List<String> getListByDir(String dirName){
         return hm.get(dirName);
    }
    public void deleteDirector(String dirName){
        List<String> movies = hm.get(dirName);
        for(String m : movies){
            movieDb.remove(m);
        }
        hm.remove(dirName);
        directorDb.remove(dirName);
    }
    public void deleteAll(){
        for(String d : hm.keySet()) {
            deleteDirector(d);
        }
        directorDb.clear();
    }
}
