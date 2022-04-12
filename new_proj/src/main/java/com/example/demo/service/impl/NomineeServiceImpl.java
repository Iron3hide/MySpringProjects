package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Nominee;
import com.example.demo.repository.NomineeRepository;
import com.example.demo.service.NomineeService;

@Service
public class NomineeServiceImpl implements NomineeService {

    private NomineeRepository nomineeRepository;

    public NomineeServiceImpl(NomineeRepository nomineeRepository) {
        super();
        this.nomineeRepository = nomineeRepository;
    }

    @Override
    public Nominee saveNominee(Nominee nominee) {
        return nomineeRepository.save(nominee);
    }

    @Override
    public List<Nominee> getAllNominees() {
        return nomineeRepository.findAll();
    }

    @Override
    public Nominee getNomineeById(long id) {
        Optional<Nominee> nominee = nomineeRepository.findById(id);
        /*if (nominee.isPresent()){
            return nominee.get();
        }
        else{
            throw new ResourceNotFoundException("Nominee","Id",id);
        }*/
        return nomineeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nominee","Id","id"));
    }

    @Override
    public Nominee updateNominee(Nominee nominee, long id) {

        //we need to check whether nominee with given id is present in database or not
        Nominee existingNominee = nomineeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nominee","Id",id));

        existingNominee.setName(nominee.getName());
        existingNominee.setDob(nominee.getDob());
        existingNominee.setRelationShip(nominee.getRelationShip());
        existingNominee.setAddress1(nominee.getAddress1());
        existingNominee.setAddress2(nominee.getAddress2());
        existingNominee.setAddress3(nominee.getAddress3());
        existingNominee.setAddress4(nominee.getAddress4());

        // save existing employee to database
        nomineeRepository.save(existingNominee);
        return existingNominee;
    }

    @Override
    public void deleteNominee(long id) {

        // we need to check whether Nominee with given id is present in database or not
        nomineeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nominee","Id",id));
        nomineeRepository.deleteById(id);
    }
}