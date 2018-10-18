package ru.innopolis.stc13.student_test;

import ru.innopolis.stc13.student_test.pojo.Answer;
import ru.innopolis.stc13.student_test.pojo.Question;
import ru.innopolis.stc13.student_test.pojo.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.innopolis.stc13.student_test.UserTestData.TEACHER1;
import static ru.innopolis.stc13.student_test.UserTestData.TEACHER2;

public class TestTestData {

    public static final Test TEST1 = new Test(1, "test description 1",
            TEACHER1,
//            Collections.emptySet()
            Arrays.asList(new Question(1, "question text 1-1",
//                    Collections.emptySet()
                            Arrays.asList(
                                    new Answer(1, "answer text 1-1-1", true),
                                    new Answer(2, "answer text 1-1-2", false),
                                    new Answer(3, "answer text 1-1-3", false),
                                    new Answer(4, "answer text 1-1-4", false))
                                    .stream().collect(Collectors.toSet())
                    ),
                    new Question(2, "question text 1-2", Arrays.asList(
                            new Answer(5, "answer text 1-2-1", false),
                            new Answer(6, "answer text 1-2-2", false),
                            new Answer(7, "answer text 1-2-3", true),
                            new Answer(8, "answer text 1-2-4", false))
                            .stream().collect(Collectors.toSet())
                    ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST2 = new Test(2, "test description 2",
            TEACHER1,
            Arrays.asList(new Question(3, "question text 2-1", Arrays.asList(
                    new Answer(9, "answer text 2-1-1", false),
                    new Answer(10, "answer text 2-1-2", true),
                    new Answer(11, "answer text 2-1-3", false),
                    new Answer(12, "answer text 2-1-4", false))
                            .stream().collect(Collectors.toSet())
                    ),
                    new Question(4, "question text 2-2", Arrays.asList(
                            new Answer(13, "answer text 2-2-1", false),
                            new Answer(14, "answer text 2-2-2", false),
                            new Answer(15, "answer text 2-2-3", true),
                            new Answer(16, "answer text 2-2-4", false))
                            .stream().collect(Collectors.toSet())
                    ),
                    new Question(5, "question text 2-3", Arrays.asList(
                            new Answer(17, "answer text 2-3-1", false),
                            new Answer(18, "answer text 2-3-2", false),
                            new Answer(19, "answer text 2-3-3", false),
                            new Answer(20, "answer text 2-3-4", true))
                            .stream().collect(Collectors.toSet())
                    ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST3 = new Test(3, "test description 3",
            TEACHER2,
            Arrays.asList(new Question(6, "question text 3-1", Arrays.asList(
                    new Answer(21, "answer text 3-1-1", false),
                    new Answer(22, "answer text 3-1-2", false),
                    new Answer(23, "answer text 3-1-3", false),
                    new Answer(24, "answer text 3-1-4", true))
                            .stream().collect(Collectors.toSet())
                    ),
                    new Question(7, "question text 3-2", Arrays.asList(
                            new Answer(25, "answer text 3-2-1", false),
                            new Answer(26, "answer text 3-2-2", false),
                            new Answer(27, "answer text 3-2-3", false),
                            new Answer(28, "answer text 3-2-4", true))
                            .stream().collect(Collectors.toSet())
                    ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST4 = new Test("test description 4",
            TEACHER2,
            Arrays.asList(new Question("question text 4-1", Arrays.asList(
                    new Answer("answer text 4-1-1", true),
                    new Answer("answer text 4-1-2", false),
                    new Answer("answer text 4-1-3", false),
                    new Answer("answer text 4-1-4", false))
                    .stream().collect(Collectors.toSet())
            ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST4_SAVED = new Test(4, "test description 4",
            TEACHER2,
            Arrays.asList(new Question(8, "question text 4-1", Arrays.asList(
                    new Answer(29, "answer text 4-1-1", true),
                    new Answer(30, "answer text 4-1-2", false),
                    new Answer(31, "answer text 4-1-3", false),
                    new Answer(32, "answer text 4-1-4", false))
                    .stream().collect(Collectors.toSet())
            ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST1_UPDATED = new Test(1, "updated description 1",
            TEACHER1,
            Arrays.asList(new Question(1, " updated question text 1-1",
                    Collections.emptySet()
//                    Arrays.asList(
//                    new Answer(1, "updated answer text 1-1-1", true),
//                    new Answer(2, "updated answer text 1-1-2", false),
//                    new Answer(3, "updated answer text 1-1-3", false),
//                    new Answer(4, "updated answer text 1-1-4", false))
//                    .stream().collect(Collectors.toSet())
            ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final Test TEST5 = new Test(5, "description 5",
            TEACHER1,
            Arrays.asList(new Question("question text 5-1", Arrays.asList(
                    new Answer("answer text 5-1-1", true),
                    new Answer("answer text 5-1-2", false),
                    new Answer("answer text 5-1-3", false),
                    new Answer("answer text 5-1-4", false))
                    .stream().collect(Collectors.toSet())
            ))
                    .stream().collect(Collectors.toSet())
            , Collections.emptySet());

    public static final List<Test> TESTS = Arrays.asList(TEST1, TEST2, TEST3);

    public static void assertMatch(Test actual, Test expected) {
//        assertThat(actual).isEqualToIgnoringGivenFields(expected, "teacher", "questions", "groups");
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Test> actual, Test... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Test> actual, Iterable<Test> expected) {
//        assertThat(actual).usingElementComparatorIgnoringFields("teacher", "questions", "groups").isEqualTo(expected);
        assertThat(actual).isEqualTo(expected);
    }
}
