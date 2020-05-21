/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.movieinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.microservices.movieinfoservice.model.Movie;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/movies")
public class MovieResource
{

  @RequestMapping("/{movieId}")
  public Movie getMovieInfo(@PathVariable String movieId)
  {
    return new Movie(movieId, "My Movie");
    
    
  }
}
