package com.renanb.fly_way_backend.repository;

import com.renanb.fly_way_backend.model.Trip;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends ReactiveCrudRepository<Trip, Long> {
}
