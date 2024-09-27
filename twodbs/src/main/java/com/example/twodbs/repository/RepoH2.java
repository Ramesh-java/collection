package com.example.twodbs.repository;

import com.example.twodbs.model.EntityH2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoH2 extends JpaRepository<EntityH2,Long> {
}
