package com.mh.hunt.repository;

import com.mh.hunt.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonsterRepository extends JpaRepository<Monster, UUID> {

}
