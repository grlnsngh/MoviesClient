/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movie_rest.services;

import com.mycompany.moviesoap.services.MovieService;
import com.mycompany.moviesoap.services.MovieService_Service;
import com.mycompany.moviesoap.services.Movies;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author grlns
 */
@Path("getmovies")
@Produces("text/json")
public class MService {
    
    @Path("all")
    @GET
    public Response getAll() {
        MovieService_Service service = new MovieService_Service();
        MovieService port = service.getMovieServicePort();
        List<Movies> movies = port.viewMovie();
        return Response.ok(movies).build();
    }

    @Path("all/{id}")
    @GET
    public Response getMovie(@PathParam("id") int id) {
        MovieService_Service service = new MovieService_Service();
        MovieService port = service.getMovieServicePort();
        Movies movies = port.findMovie(BigDecimal.valueOf(id));
        return Response.ok(movies).build();
    }
    
}
