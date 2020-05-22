/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

/**
 * @author gopinath_mb
 */
@SpringBootApplication
public class MovieCatalogueServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(MovieCatalogueServiceApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate()
  {
    return new RestTemplate();
  }

  public Builder getWebClientBuilder()
  {

    return WebClient.builder();
  }

}
