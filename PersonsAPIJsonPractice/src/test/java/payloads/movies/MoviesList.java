package payloads.movies;

import java.util.List;

public class MoviesList {
    private String title;
    private String director;
    private List<Cast> cast;
    private double rating;
    private BoxOffice boxOffice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BoxOffice getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(BoxOffice boxOffice) {
        this.boxOffice = boxOffice;
    }
}
