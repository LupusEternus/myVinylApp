package com.example.myVinylApp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Release {

    @Id
    private Integer id;
    private Format format;
    private String title;
    @ManyToMany
    @JoinTable(
            name="release_artist",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artistIds;
    private String picUrl;
    private String releaseDate;
    private String country;





}
