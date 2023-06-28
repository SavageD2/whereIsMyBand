package com.example.whereIsMyBand.repositories;

import com.example.whereIsMyBand.profiles.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
