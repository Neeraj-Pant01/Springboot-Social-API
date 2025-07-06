package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getUserProfiles(){
        return profileService.getProfiles();
    }

    @GetMapping("/{id}")
    public  Profile getUserById(@PathVariable Long id){
        return  profileService.getProfileById(id);
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile){
        return  profileService.createProfile(profile);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Long id , @RequestBody Profile profile){
        return profileService.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
    }


    @GetMapping("/user/{userId}")
    public Profile getProfileByUserId(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId);
    }


}
