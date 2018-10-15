package ru.innopolis.stc13.student_test;

import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.HashSet;
import java.util.Set;

public class UserTestData {

    public static final Set<Role> ADMIN_SET = new HashSet<>();
    public static final Set<Role> STUDENT_SET = new HashSet<>();
    public static final Set<Role> TEACHER_SET = new HashSet<>();

    public static final User TEACHER1;
    public static final User TEACHER2;
    public static final User STUDENT;
    public static final User ADMIN;

    static {
        ADMIN_SET.add(Role.ADMIN);
        STUDENT_SET.add(Role.STUDENT);
        TEACHER_SET.add(Role.TEACHER);

        TEACHER1 = new User("teacher_login", "5", "teacher_name", null, null, TEACHER_SET);
        TEACHER2 = new User("teacher_login2", "5", "teacher_name2", null, null, TEACHER_SET);
        STUDENT = new User("student_login", "5", "student_name", null, null, STUDENT_SET);
        ADMIN = new User("admin_login", "5", "admin_name", null, null, ADMIN_SET);
    }
}
