package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Guardian;
import com.example.demo.repository.GuardianRepository;
import com.example.demo.service.GuardianService;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianServiceImpl implements GuardianService {

    private GuardianRepository guardianRepository;

    public GuardianServiceImpl(GuardianRepository guardianRepository) {
        super();
        this.guardianRepository = guardianRepository;
    }

    @Override
    public Guardian saveGuardian(Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    @Override
    public List<Guardian> getAllGuardians() {
        return guardianRepository.findAll();
    }

    @Override
    public Guardian getGuardianById(long id_Guardian) {
        Optional<Guardian> guardian = guardianRepository.findById(id_Guardian);

        return guardianRepository.findById(id_Guardian).orElseThrow(() -> new ResourceNotFoundException("Guardian","Id","id_Guardian"));
    }

    @Override
    public Guardian updateGuardian(Guardian guardian, long id_Guardian) {

        //we need to check whether nominee with given id is present in database or not
        Guardian existingGuardian = guardianRepository.findById(id_Guardian).orElseThrow(()-> new ResourceNotFoundException("Guardian","Id","id_Guardian"));

        existingGuardian.setName_Guardian(guardian.getName_Guardian());
        existingGuardian.setDob_Guardian(guardian.getDob_Guardian());
        existingGuardian.setRelationShip_Guardian(guardian.getRelationShip_Guardian());
        existingGuardian.setAddress1_Guardian(guardian.getAddress1_Guardian());
        existingGuardian.setAddress2_Guardian(guardian.getAddress2_Guardian());
        existingGuardian.setAddress3_Guardian(guardian.getAddress3_Guardian());
        existingGuardian.setAddress4_Guardian(guardian.getAddress4_Guardian());

        // save existing employee to database
        guardianRepository.save(existingGuardian);
        return existingGuardian;
    }

    @Override
    public void deleteGuardian(long id_Guardian) {
        // we need to check whether Nominee with given id is present in database or not
        guardianRepository.findById(id_Guardian).orElseThrow(()-> new ResourceNotFoundException("Guardian","Id","id_Guardian"));
        guardianRepository.deleteById(id_Guardian);
    }
}