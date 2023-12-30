package com.springdatajpamappings.repositories;

import com.springdatajpamappings.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
