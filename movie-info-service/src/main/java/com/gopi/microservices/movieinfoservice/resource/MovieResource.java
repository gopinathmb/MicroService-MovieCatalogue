/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.movieinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gopi.microservices.movieinfoservice.model.Movie;
import com.gopi.microservices.movieinfoservice.model.MovieSummary;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/movies")
public class MovieResource
{

  @Value("${api-key}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/{movieId}")
  public Movie getMovieInfo(@PathVariable String movieId)
  {

    MovieSummary movieSummary = restTemplate.getForObject(
        "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
        MovieSummary.class);
    return new Movie(movieSummary.getId().toString(), movieSummary.getTitle(),
        movieSummary.getOverview());

  }
}
