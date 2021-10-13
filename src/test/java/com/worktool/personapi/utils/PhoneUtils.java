package com.worktool.personapi.utils;

import com.worktool.personapi.dto.request.PhoneDTO;
import com.worktool.personapi.entity.Phone;
import com.worktool.personapi.enums.PhoneType;


public class PhoneUtils {


    private static final String PHONE_NUMBER = "119999-99999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }


}
