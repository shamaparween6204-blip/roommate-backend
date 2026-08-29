package com.roommate.roommate_backend.controller;

import com.roommate.roommate_backend.model.RoomListing;
import com.roommate.roommate_backend.repository.RoomListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.roommate.roommate_backend.model.User;
import com.roommate.roommate_backend.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/roomListings")
public class RoomListingController {

    @Autowired
    private RoomListingRepository roomListingRepository;

    @Autowired
    private UserRepository userRepository;

   @PostMapping
public RoomListing createRoomListing(@RequestBody RoomListing roomListing) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    User currentUser = userRepository.findByEmail(email);
    roomListing.setUser(currentUser);
    return roomListingRepository.save(roomListing);
}


    @GetMapping
    public List<RoomListing> getAllRoomListings() {
        return roomListingRepository.findAll();
    }

    @GetMapping("/search/location")
public List<RoomListing> searchByLocation(@RequestParam String location) {
    return roomListingRepository.findByLocationContainingIgnoreCase(location);
}

@GetMapping("/search/rent")
public List<RoomListing> searchByMaxRent(@RequestParam Double maxRent) {
    return roomListingRepository.findByRentLessThanEqual(maxRent);
}
}