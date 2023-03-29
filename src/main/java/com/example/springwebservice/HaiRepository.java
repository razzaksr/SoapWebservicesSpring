package com.example.springwebservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaiRepository extends JpaRepository<Hai,Integer> {
}
