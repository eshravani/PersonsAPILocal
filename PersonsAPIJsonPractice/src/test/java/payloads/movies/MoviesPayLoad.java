package payloads.movies;

import java.util.List;

public class MoviesPayLoad {

    /*
    releaseYear
     */
    private String genre;
    private int releaseYear;
    private List<MoviesList> moviesList;

    public String getGenre()
    {
        return this.genre;
    }

    public int getReleaseYear()
    {
        return this.releaseYear;
    }

    public List<MoviesList> getMoviesList(){
        return this.moviesList;
    }

    public void setMoviesList(List<MoviesList> moviesList)
    {
        this.moviesList=moviesList;
    }
}
