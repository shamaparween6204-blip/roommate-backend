package com.roommate.roommate_backend.repository;

import com.roommate.roommate_backend.model.RoomListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomListingRepository extends JpaRepository<RoomListing, Long> {


    List<RoomListing> findByLocationContainingIgnoreCase(String location);

    
    List<RoomListing> findByRentLessThanEqual(Double rent);
}