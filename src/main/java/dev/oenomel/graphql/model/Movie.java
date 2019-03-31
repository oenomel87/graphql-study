package dev.oenomel.graphql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_code")
    private int code;

    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "running_time")
    private int runningTime;

    @OneToMany(mappedBy = "movie")
    private List<Cast> casts;
}
