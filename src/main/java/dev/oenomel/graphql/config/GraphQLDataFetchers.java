package dev.oenomel.graphql.config;

import dev.oenomel.graphql.model.Actor;
import dev.oenomel.graphql.model.Movie;
import dev.oenomel.graphql.repository.ActorRepository;
import dev.oenomel.graphql.repository.MovieRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    public DataFetcher<Movie> findMovieByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            int movieCode = dataFetchingEnvironment.getArgument("code");
            return movieRepository.findById(movieCode).orElse(null);
        };
    }

    public DataFetcher<Actor> findActorByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            int actorCode = dataFetchingEnvironment.getArgument("code");
            return actorRepository.findById(actorCode).orElse(null);
        };
    }
}
