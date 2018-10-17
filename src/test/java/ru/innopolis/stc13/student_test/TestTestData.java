package ru.innopolis.stc13.student_test;

import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.innopolis.stc13.student_test.UserTestData.TEACHER1;
import static ru.innopolis.stc13.student_test.UserTestData.TEACHER2;

public class TestTestData {

    public static final Test TEST1 = new Test("test description 1",
            TEACHER1,
            Arrays.asList(new Question("question text 1", Arrays.asList(
                    new Answer("answer text 1", true),
                    new Answer("answer text 2", false),
                    new Answer("answer text 3", false),
                    new Answer("answer text 4", false))),
                    new Question("question text 2", Arrays.asList(
                            new Answer("answer text 1", false),
                            new Answer("answer text 2", false),
                            new Answer("answer text 3", true),
                            new Answer("answer text 4", false)))));

    public static final Test TEST2 = new Test("test description 2",
            TEACHER1,
            Arrays.asList(new Question("question text 1", Arrays.asList(
                    new Answer("answer text 1", false),
                    new Answer("answer text 2", true),
                    new Answer("answer text 3", false),
                    new Answer("answer text 4", false))),
                    new Question("question text 2", Arrays.asList(
                            new Answer("answer text 1", false),
                            new Answer("answer text 2", false),
                            new Answer("answer text 3", true),
                            new Answer("answer text 4", false))),
                    new Question("question text 3", Arrays.asList(
                            new Answer("answer text 1", false),
                            new Answer("answer text 2", false),
                            new Answer("answer text 3", false),
                            new Answer("answer text 4", true)))));

    public static final Test TEST3 = new Test("test description 3",
            TEACHER2,
            Arrays.asList(new Question("question text 1", Arrays.asList(
                    new Answer("answer text 1", false),
                    new Answer("answer text 2", false),
                    new Answer("answer text 3", false),
                    new Answer("answer text 4", true))),
                    new Question("question text 2", Arrays.asList(
                            new Answer("answer text 1", false),
                            new Answer("answer text 2", false),
                            new Answer("answer text 3", false),
                            new Answer("answer text 4", true)))));

    public static final Test TEST4 = new Test("test description 4",
            TEACHER2,
            Arrays.asList(new Question("question text 1", Arrays.asList(
                    new Answer("answer text 1", true),
                    new Answer("answer text 2", false),
                    new Answer("answer text 3", false),
                    new Answer("answer text 4", false)))));

    public static final Test TEST1_UPDATED = new Test(1, "updated description 1",
            TEACHER1,
            Arrays.asList(new Question(" updated question text 1", Arrays.asList(
                    new Answer("updated answer text 1", true),
                    new Answer("updated answer text 2", false),
                    new Answer("updated answer text 3", false),
                    new Answer("updated answer text 4", false)))));

    public static final Test TEST5 = new Test(5, "description 5",
            TEACHER1,
            Arrays.asList(new Question("question text 1", Arrays.asList(
                    new Answer("answer text 1", true),
                    new Answer("answer text 2", false),
                    new Answer("answer text 3", false),
                    new Answer("answer text 4", false)))));

    public static final List<Test> TESTS = Arrays.asList(TEST3, TEST2, TEST1);

    public static void assertMatch(Test actual, Test expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Test> actual, Test... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Test> actual, Iterable<Test> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("teacher").isEqualTo(expected);
    }
}
