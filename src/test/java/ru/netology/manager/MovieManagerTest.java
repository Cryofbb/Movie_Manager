package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager manager = new MovieManager();

    private Movies movie1 = new Movies(1, 111, "The Fast and the Furious", "боевик");
    private Movies movie2 = new Movies(2, 222, "2 Fast 2 Furious", "боевик");
    private Movies movie3 = new Movies(3, 333, "The Fast and the Furious: Tokyo Drift", "боевик");
    private Movies movie4 = new Movies(4, 444, "Fast & Furious", "боевик");
    private Movies movie5 = new Movies(5, 555, "Fast Five", "боевик");
    private Movies movie6 = new Movies(6, 666, "Fast & Furious 6", "боевик");
    private Movies movie7 = new Movies(7, 777, "Furious 7", "боевик");
    private Movies movie8 = new Movies(8, 888, "The Fate of the Furious", "боевик");
    private Movies movie9 = new Movies(9, 999, "F9", "боевик");
    private Movies movie10 = new Movies(10, 1000, "Fast & Furious 10", "боевик");
    private Movies movie11 = new Movies(11, 1111, "Fast & Furious Presents: Hobbs & Shaw", "боевик");

    @BeforeEach
    public void setup() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
    }

    @Test
    // Выдача при массиве менее 10
    public void showWhenLessTen() {
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выдача 10 последних, если в массиве более 10
    public void showMax() {
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выдача количества больше 10
    public void showMoreMax() {
        MovieManager manager = new MovieManager(12);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        manager.addMovie(movie1);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie1, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выдать 1
    public void showMin() {
        MovieManager manager = new MovieManager(1);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        manager.addMovie(movie1);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showFive() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        manager.addMovie(movie1);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie1, movie11, movie10, movie9, movie8};
        assertArrayEquals(expected, actual);
    }

    @Test
    //Выдача больше массива
    public void showMoreThanGot() {
        manager.setDefaultLength(12);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    //Выдача отрицательного значения
    public void showLessZero() {
        manager.setDefaultLength(-1);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выдать 0
    public void showZero() {
        manager.setDefaultLength(0);
        Movies[] actual = manager.showMovies();
        Movies[] expected = new Movies[]{};
        assertArrayEquals(expected, actual);
    }
}