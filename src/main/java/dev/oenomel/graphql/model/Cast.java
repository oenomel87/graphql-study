package dev.oenomel.graphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cast_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_code")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_code")
    private Actor actor;
}
