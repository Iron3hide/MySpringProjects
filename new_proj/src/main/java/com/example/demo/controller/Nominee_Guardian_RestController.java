package com.example.demo.controller;

import com.example.demo.model.Guardian;
import com.example.demo.model.Nominee;
import com.example.demo.service.GuardianService;
import com.example.demo.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/api/nominees")
public class Nominee_Guardian_RestController {

    @Autowired
    private NomineeService nomineeService;

    @Autowired
    private GuardianService guardianService;

    public Nominee_Guardian_RestController(NomineeService nomineeService,GuardianService guardianService) {
        super();
        this.nomineeService = nomineeService;
        this.guardianService = guardianService;
    }

    // build create nominee REST API
    @PostMapping("/api/nominees")
    public ResponseEntity<Nominee> saveNominee(@RequestBody Nominee nominee) {
        return new ResponseEntity<Nominee>(nomineeService.saveNominee(nominee), HttpStatus.CREATED);
    }

    // build get all nominees REST API
    @GetMapping("/api/nominees")
    public List<Nominee> getAllNominees() {
        return nomineeService.getAllNominees();
    }

    // build get nominee by id REST API
    // http://localhost:8080/api/nominees/1
    @GetMapping("/api/nominees/{id}")
    public ResponseEntity<Nominee> getNomineeById(@PathVariable("id") long nomineeId){
        return new ResponseEntity<Nominee>(nomineeService.getNomineeById(nomineeId),HttpStatus.OK);
    }

    // build update nominee REST API
    // http://localhost:8080/api/nominees/1
    @PutMapping("/api/nominees/{id}")
    public ResponseEntity<Nominee> updateNominee(@PathVariable("id") long id, @RequestBody Nominee nominee){
        return new ResponseEntity<Nominee>(nomineeService.updateNominee(nominee,id),HttpStatus.OK);
    }

    // build delete nominee REST API
    // http://localhost:8080/api/nominees/1
    @DeleteMapping("/api/nominees/{id}")
    public ResponseEntity<String> deleteNominee(@PathVariable("id") long id){

        // delete employee from database
        nomineeService.deleteNominee(id);

        return new ResponseEntity<String>("Nominee deleted successfully!",HttpStatus.OK);
    }

    // build create Guardian REST API
    @PostMapping("/api/guardians")
    public ResponseEntity<Guardian> saveGuardian(@RequestBody Guardian guardian) {
        return new ResponseEntity<Guardian>(guardianService.saveGuardian(guardian), HttpStatus.CREATED);
    }

    // build get all guardians REST API
    @GetMapping("/api/guardians")
    public List<Guardian> getAllGuardians() {
        return guardianService.getAllGuardians();
    }
    // build get guardian by id REST API
    // http://localhost:8080/guardians/1
    @GetMapping("/api/guardians/{id_Guardian}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("id_Guardian") long Id_Guardian){
        return new ResponseEntity<Guardian>(guardianService.getGuardianById(Id_Guardian),HttpStatus.OK);
    }

    // build update guardian REST API
    // http://localhost:8080/guardians/1
    @PutMapping("/api/guardians/{id_Guardian}")
    public ResponseEntity<Guardian> updateGuardian(@PathVariable("id_Guardian") long id_Guardian, @RequestBody Guardian guardian){
        return new ResponseEntity<Guardian>(guardianService.updateGuardian(guardian,id_Guardian),HttpStatus.OK);
    }

    // build delete guardian REST API
    // http://localhost:8080/guardians/1
    @DeleteMapping("/api/guardians/{id_Guardian}")
    public ResponseEntity<String> deleteGuardian(@PathVariable("id_Guardian") long id_Guardian){

        // delete employee from database
        guardianService.deleteGuardian(id_Guardian);

        return new ResponseEntity<String>("Guardian deleted successfully!",HttpStatus.OK);
    }
}