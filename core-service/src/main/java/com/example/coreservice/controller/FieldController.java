package com.example.coreservice.controller;

import com.example.coreservice.dto.FieldDTO;
import com.example.coreservice.repository.FieldRepository;
import com.example.coreservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
