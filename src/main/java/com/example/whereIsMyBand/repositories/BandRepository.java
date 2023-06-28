package com.example.whereIsMyBand.repositories;

import com.example.whereIsMyBand.profiles.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

   Band findByCity(String city);

}
