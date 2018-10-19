package ru.innopolis.stc13.student_test;

import ru.innopolis.stc13.student_test.pojo.Role;
import ru.innopolis.stc13.student_test.pojo.User;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTestData {

    public static final Set<Role> ADMIN_SET = new HashSet<>();
    public static final Set<Role> STUDENT_SET = new HashSet<>();
    public static final Set<Role> TEACHER_SET = new HashSet<>();

    public static final User TEACHER1;
    public static final User TEACHER2;
    public static final User TEACHER2_UPDATED;
    public static final User TEACHER3;
    public static final User TEACHER4;
    public static final User STUDENT;
    public static final User ADMIN;

    public static final List<User> USERS;

    static {
        ADMIN_SET.add(Role.ADMIN);
        STUDENT_SET.add(Role.STUDENT);
        TEACHER_SET.add(Role.TEACHER);

        TEACHER1 = new User(1, "teacher_login", "5", "teacher_name", Collections.emptySet(), null, TEACHER_SET);
        TEACHER2 = new User(2, "teacher_login2", "5", "teacher_name2", Collections.emptySet(), null, TEACHER_SET);
        TEACHER2_UPDATED = new User(2, "teacher_login2_updated", "5updated", "teacher_name2 updated", Collections.emptySet(), null, TEACHER_SET);
        TEACHER3 = new User("teacher_login3", "5", "teacher_name3", Collections.emptySet(), null, TEACHER_SET);
        TEACHER4 = new User(6, "teacher_login4", "5", "teacher_name4", Collections.emptySet(), null, TEACHER_SET);
        STUDENT = new User(3, "student_login", "5", "student_name", Collections.emptySet(), null, STUDENT_SET);
        ADMIN = new User(4, "admin_login", "5", "admin_name", Collections.emptySet(), null, ADMIN_SET);

        USERS = Arrays.asList(TEACHER1, TEACHER2, STUDENT, ADMIN);
    }

    public static void assertMatch(User actual, User expected) {
//        assertThat(actual).isEqualToIgnoringGivenFields(expected, "teacher", "questions", "groups");
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
//        assertThat(actual).usingElementComparatorIgnoringFields("teacher", "questions", "groups").isEqualTo(expected);
        assertThat(actual).isEqualTo(expected);
    }
}
