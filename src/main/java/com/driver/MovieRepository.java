package com.driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<Director,List<Movie>> hm = new HashMap<>();
    private HashMap<String,Movie> movieDb = new HashMap<>();
    private HashMap<String,Director> directorDb = new HashMap<>();

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
    public void addPair(Movie m,Director d){
        if(hm.containsKey(d)) {
            List<Movie> movies = hm.get(d);
            movies.add(m);
            hm.put(d,movies);
        }
        else {
            List<Movie> movieList= new ArrayList<>();
            movieList.add(m);
            hm.put(d,movieList);
        }
    }
    public List<String> getListByDir(Director d){
        List<Movie> movieList = hm.get(d);
        List<String> list  = new ArrayList<>();
        for(Movie m: movieList ){
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
    }
}
