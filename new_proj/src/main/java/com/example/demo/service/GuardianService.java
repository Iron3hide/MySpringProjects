package com.example.demo.service;

import com.example.demo.model.Guardian;

import java.util.List;

public interface GuardianService{

    Guardian saveGuardian(Guardian guardian);

    List<Guardian> getAllGuardians();

    Guardian getGuardianById(long id_Guardian);

    Guardian updateGuardian(Guardian guardian, long id_Guardian);

    void deleteGuardian(long id_Guardian);
}
