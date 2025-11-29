package com.example.coreservice.controller;

import com.example.coreservice.dto.SportTypeDTO;
import com.example.coreservice.service.SportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("core/api/v1")
public class SportTypeController {
    @Autowired
    public SportTypeService sportTypeService;
    @GetMapping("sport_types")
    public ResponseEntity<List<SportTypeDTO>> getAllSportTypes(){
        return new ResponseEntity<>(this.sportTypeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("sport_types")
    public ResponseEntity<SportTypeDTO> saveSportType(@RequestBody SportTypeDTO sportTypeDTO){
        return new ResponseEntity<>(this.sportTypeService.saveSportType(sportTypeDTO),HttpStatus.CREATED);
    }

    @GetMapping("/sport_types/{id}")
    public ResponseEntity<SportTypeDTO> getSportType(@PathVariable Integer id){
        return new ResponseEntity<>(this.sportTypeService.getSportTypeById(id),HttpStatus.OK);
    }

    @PutMapping("sport_types")
    public ResponseEntity<SportTypeDTO>  updateSportType(@RequestBody SportTypeDTO sportTypeDTO){
        return new ResponseEntity<>(this.sportTypeService.updateSportType(sportTypeDTO),HttpStatus.OK);
    }
    @DeleteMapping("/sport_types/{id}")
    public ResponseEntity<String> DeleteSportType(@PathVariable Integer id){
        return new ResponseEntity<>(this.sportTypeService.deleteSportType(id),HttpStatus.OK);
    }
}
