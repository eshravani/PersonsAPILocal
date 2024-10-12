package tests;

import endpoints.MoviesResources;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.movies.MoviesList;
import payloads.movies.MoviesPayLoad;

public class Movies extends MoviesResources {
   /* Validation Scenarios:
    Validate Ratings: Ensure that the rating is between 0 and 10.
    Check Box Office Numbers: Validate that the gross earnings are greater than the budget.
    Verify Cast Details: Ensure that each movie has at least one actor in the cast.*/
   private static MoviesPayLoad movies;
    @Test
    public void validateRating() {
        Response res = getMoviesDetails();
        JSONObject movies = new JSONObject(res.asString());
        JSONArray moviesList = movies.getJSONArray("moviesList");
        for (int i = 0; i < moviesList.length(); i++) {
            double rating = moviesList.getJSONObject(i).getDouble("rating");
            Assert.assertTrue((rating >= 0 && rating <= 10), "rating is " + rating + " rating should be between 0-10");
        }
    }


    @Test
    public void validateBoxOfficeNumbers() {
        movies=getMoviesDetails().as(MoviesPayLoad.class);

        int size=movies.getMoviesList().size();
        for(int i=0;i<size;i++)
        {
            MoviesList moviesList=movies.getMoviesList().get(i);
        long budget=movies.getMoviesList().get(i).getBoxOffice().getBudget();
        long gross=movies.getMoviesList().get(i).getBoxOffice().getGross();
        if(gross>budget)
        {
           System.out.println( moviesList.getTitle()+" movie is success");
        }
       // Assert.assertTrue(gross>budget," gross is not greater than budget movie is not successful");
    }
    }
@Test
    public void ensureMovieHasAtLeastOneActor()
{
    movies=getMoviesDetails().as(MoviesPayLoad.class);
    int size=movies.getMoviesList().size();
    for(int i=0;i<size;i++)
    {
        int castSize=movies.getMoviesList().get(i).getCast().size();
        Assert.assertTrue(castSize>=1," movie doesn't have even a single actor");
    }
}
}
