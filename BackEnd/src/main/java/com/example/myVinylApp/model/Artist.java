package com.example.myVinylApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1000)
    private String profile;
    @ManyToMany
    @JoinTable(
            name =  "artist_members",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Artist> members;
    @ElementCollection
    private Set<String> imageUrls;
    private String resourceURL;

    public Artist(Set<Artist> members, Set<String> imageUrls, String resourceURL) {
        this.members = members;
        this.imageUrls = imageUrls;
        this.resourceURL = resourceURL;
    }
}
