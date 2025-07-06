package com.example.demo.services;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id){
        return profileRepository.findById(id).orElse(null);
    }

    public Profile createProfile(Profile profile){
        return  profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile updatedProfile){
        Profile profile = profileRepository.findById(id).orElse(null);
        if(profile != null){
            profile.setBio(updatedProfile.getBio());
            profile.setPhone(updatedProfile.getPhone());
            return profileRepository.save(profile);
        }
        return null;
    }

    public void deleteProfile(Long id){
        profileRepository.deleteById(id);
    }

    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found for user id: " + userId));
    }


}
