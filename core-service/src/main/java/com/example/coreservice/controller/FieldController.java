package com.example.coreservice.controller;

import com.example.coreservice.dto.FieldCreateDTO;
import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.dto.FieldResponseDTO;
import com.example.coreservice.model.Field;
import com.example.coreservice.repository.FieldRepository;
import com.example.coreservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("core/api/v1")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("fields")
    public ResponseEntity<List<FieldDTO>> findAllFields(){
        return new ResponseEntity<>(this.fieldService.getAll(), HttpStatus.OK);
    }
    @PostMapping("fields")
    public ResponseEntity<FieldResponseDTO> createField(@ModelAttribute FieldCreateDTO fieldCreateDTO) throws IOException {
        return new ResponseEntity<>(this.fieldService.saveField(fieldCreateDTO), HttpStatus.CREATED);
    }
    @GetMapping("/fields/{id}")
    public ResponseEntity<FieldDTO> findFieldById(@PathVariable Integer id){
        return new ResponseEntity<>(this.fieldService.getById(id), HttpStatus.OK);
    }
    @PutMapping("fields")
    public ResponseEntity<FieldDTO> updateField(@RequestBody FieldDTO fieldDTO){
        return new ResponseEntity<>(this.fieldService.updateField(fieldDTO), HttpStatus.OK);
    }
    @DeleteMapping("/fields/{id}")
    public ResponseEntity<String> deleteFieldById(@PathVariable Integer id){
        return new ResponseEntity<>(this.fieldService.deleteField(id), HttpStatus.OK);
    }
}
