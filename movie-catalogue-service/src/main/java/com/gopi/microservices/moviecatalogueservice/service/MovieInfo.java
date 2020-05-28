/**
 * Created by gopinath_mb on 27-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gopi.microservices.moviecatalogueservice.model.Movie;
import com.gopi.microservices.moviecatalogueservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author gopinath_mb
 */
@Service
public class MovieInfo
{
  
  @Autowired
  private RestTemplate restTemplate;
  
  @HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
  public Movie getMovieInfo(Rating rating)
  {
    return restTemplate.getForObject(
        "http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
  }

  private Movie getFallbackMovieInfo(Rating rating)
  {
    return new Movie(rating.getMovieId(), "Fallback Movie Name", "Fallback Movie description");
  }
}
