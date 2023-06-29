package com.example.whereIsMyBand.profiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String groupName;
    private String description;
    private String banner;
    private String city;
    private String website;

    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("band") //Cela permet d'éviter la récursion infinie lors de la sérialisation de la relation bidirectionnelle
    private List<Announce> announces;

}
