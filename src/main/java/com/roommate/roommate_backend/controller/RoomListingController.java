package com.roommate.roommate_backend.controller;

import com.roommate.roommate_backend.model.RoomListing;
import com.roommate.roommate_backend.repository.RoomListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomListings")
public class RoomListingController {

    @Autowired
    private RoomListingRepository roomListingRepository;

    @PostMapping
    public RoomListing createRoomListing(@RequestBody RoomListing roomListing) {
        return roomListingRepository.save(roomListing);
    }

    @GetMapping
    public List<RoomListing> getAllRoomListings() {
        return roomListingRepository.findAll();
    }
}