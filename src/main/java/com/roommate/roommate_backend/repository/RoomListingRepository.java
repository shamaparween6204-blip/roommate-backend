package com.roommate.roommate_backend.repository;

import com.roommate.roommate_backend.model.RoomListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomListingRepository extends JpaRepository<RoomListing, Long> {
    RoomListing findByLocation(String location);
} 