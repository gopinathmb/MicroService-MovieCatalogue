/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.gopi.microservices.moviecatalogueservice.model.CatalogItem;
import com.gopi.microservices.moviecatalogueservice.model.Movie;
import com.gopi.microservices.moviecatalogueservice.model.Rating;
import com.gopi.microservices.moviecatalogueservice.model.UserRating;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/catalog") // For every request in the below methods starts
                            // with /catalog
public class MovieCatalogResource
{
  @Autowired
  private RestTemplate resrTemplate;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @RequestMapping("/{userId}") // Equivalent to "/catalog/{userIs}"
  public List<CatalogItem> getCatalog(@PathVariable String userId)
  {

    UserRating userRating = resrTemplate.getForObject(
        "http://localhost:8083/ratingsData/users/" + userId, UserRating.class);
    List<CatalogItem> collect = userRating.getUserRating().stream().map(rating -> {
      // This is using RestTemplate
      Movie movie = resrTemplate.getForObject(
          "http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

      return new CatalogItem(movie.getName(), "Default movie description",
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
}
