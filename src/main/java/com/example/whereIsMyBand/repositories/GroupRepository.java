package com.example.whereIsMyBand.repositories;

import com.example.whereIsMyBand.profiles.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
