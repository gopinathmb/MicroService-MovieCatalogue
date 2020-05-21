/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.microservices.moviecatalogueservice.model.CatalogItem;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/catalog") // For every request in the below methods starts
                            // with /catalog
public class MovieResource
{

  @RequestMapping("/{userId}") // Equivalent to "/catalog/{userIs}"
  public List<CatalogItem> getCatalog(String userId)
  {
    return Collections
        .singletonList(new CatalogItem("Transformers", "Good movie", 4));
  }
}
