package com.example.demo.service;

import com.example.demo.model.Nominee;

import java.util.List;

public interface NomineeService {

    Nominee saveNominee(Nominee nominee);

    List<Nominee> getAllNominees();

    Nominee getNomineeById(long id);

    Nominee updateNominee(Nominee nominee, long id);

    void deleteNominee(long id);

}