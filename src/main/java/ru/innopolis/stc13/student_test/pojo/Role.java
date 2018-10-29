package ru.innopolis.stc13.student_test.pojo;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    STUDENT, ADMIN, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
