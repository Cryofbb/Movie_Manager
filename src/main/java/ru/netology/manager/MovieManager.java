package ru.netology.manager;

import ru.netology.domain.Movies;


public class MovieManager {
    int defaultLength = 10;

    private Movies[] movies = new Movies[0];

    public MovieManager(int defaultLength) {
        this.defaultLength = defaultLength;
    }

    public MovieManager() {
    }

    public int setDefaultLength(int defaultLength){
        if (defaultLength < 0){
            return this.defaultLength;
        }
        return this.defaultLength = defaultLength;
    }

    public void addMovie(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }


    public Movies[] showMovies() {
        int length;
        if (movies.length > defaultLength) {
            length = defaultLength;
        } else {
            length = movies.length;
        }
        Movies[] result = new Movies[length];
        for (int i = 0; i < length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}