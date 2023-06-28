package com.example.whereIsMyBand.repositories;

import com.example.whereIsMyBand.profiles.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

}
