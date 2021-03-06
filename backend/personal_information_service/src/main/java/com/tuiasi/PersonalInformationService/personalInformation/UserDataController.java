package com.tuiasi.PersonalInformationService.personalInformation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDataController {

    private final UserDataRepository userDataRepository;

    public UserDataController(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @GetMapping("/api/users/coordinators")
    ResponseEntity<List<UserData>> getAllCoordinators(){
        return ResponseEntity.ok(userDataRepository.findAllCoordinators());
    }

    @GetMapping("/api/users/{idUser}")
    ResponseEntity<UserData> getUserData(@PathVariable long idUser){
        try {
            return ResponseEntity.ok(userDataRepository.findUserById(idUser));
        }
        catch(Exception ignored){
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/users/{idUser}/coordinator")
    ResponseEntity<UserData> getCoordinatorUserData(@PathVariable long idUser){
        try{
            UserData admin = userDataRepository.findCoordinatorByFaculty(userDataRepository.getFacultyByUserId(idUser));
            return ResponseEntity.ok(admin);
        }
        catch(Exception ignored){
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/users")
    ResponseEntity<Object> addUserData(@RequestBody UserData userData){
        try{
            userDataRepository.save(userData);
            return ResponseEntity.ok("204");
        }
        catch(Exception ignored){
        }
        return ResponseEntity.badRequest().build();
    }
}
