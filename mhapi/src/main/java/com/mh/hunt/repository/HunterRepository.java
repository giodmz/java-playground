package com.mh.hunt.repository;

import com.mh.hunt.model.Hunter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HunterRepository extends JpaRepository<Hunter, UUID> {

}
