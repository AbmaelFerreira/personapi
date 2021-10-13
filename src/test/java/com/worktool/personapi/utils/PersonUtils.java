package com.worktool.personapi.utils;

import com.worktool.personapi.dto.request.PersonDTO;
import com.worktool.personapi.dto.request.PhoneDTO;
import com.worktool.personapi.entity.Person;
import com.worktool.personapi.entity.Phone;
import com.worktool.personapi.enums.PhoneType;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static  final String FIRST_NAME = "Rodrigo";
    private static  final String LAST_NAME = "Rodrigo";
    private static  final String CPF_NUMBER = "012.038.553-89";
    private static  final long PERSON_ID = 1L;
    private static  final LocalDate BIRD_DATE = LocalDate.of(2010, 10, 01);


    public static PersonDTO createFakeDTO(){
        return  PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(LocalDate.parse("2010-04-04"))
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }
    public static Person createFakeEntity(){
        return  Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRD_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
