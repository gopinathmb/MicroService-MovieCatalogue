/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.gopi.microservices.moviecatalogueservice.model.CatalogItem;
import com.gopi.microservices.moviecatalogueservice.model.Movie;
import com.gopi.microservices.moviecatalogueservice.model.Rating;
import com.gopi.microservices.moviecatalogueservice.model.UserRating;
import com.gopi.microservices.moviecatalogueservice.service.MovieInfo;
import com.gopi.microservices.moviecatalogueservice.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/catalog") // For every request in the below methods starts
                            // with /catalog
public class MovieCatalogResource
{
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  MovieInfo movieInfo;

  @Autowired
  UserRatingInfo userRatingInfo;

//  @Autowired // You can check all the instances available and can use in ur
  // application.But it is not recomended as it is automatically
  // taken care.
//  private DiscoveryClient discoveryClient;

  @RequestMapping("/{userId}") // Equivalent to "/catalog/{userIs}"
//  @HystrixCommand(fallbackMethod = "getFallbackCatalog")
  public List<CatalogItem> getCatalog(@PathVariable String userId)
  {

    UserRating userRating = userRatingInfo.getRatingInfo(userId);
    List<CatalogItem> collect = userRating.getUserRating().stream()
        .map(rating -> {
          // This is using RestTemplate
          Movie movie = movieInfo.getMovieInfo(rating);

          return new CatalogItem(movie.getName(), movie.getDesc(),
              rating.getRating());
        }).collect(Collectors.toList());
    return collect;

    // This is using WebClient
//     Movie movie = webClientBuilder.build().get() // Request type
//       .uri("http://localhost:8082/movies/"+rating.getMovieId()) // Which uri
//       .retrieve() // fetch the data from above uri
//       .bodyToMono(Movie.class) // Convert body to Movie.class instance. Mono
//                                // means just a promise and will populate
//                                // soon
//                                // asynchronously.
//       .block(); // block until it is generated. So it is synchronous.

  }

  public List<CatalogItem> getFallbackCatalog(@PathVariable String userId)
  {
    return Arrays.asList(new CatalogItem("FallBack Movie Name",
        "Fallback movie description", 4));
  }
}
