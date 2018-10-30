DELETE
FROM answers;
DELETE
FROM questions;
DELETE
FROM tests;
DELETE
FROM roles;
DELETE
FROM users;
ALTER SEQUENCE users_id_seq
  RESTART WITH 1;
ALTER SEQUENCE tests_id_seq
  RESTART WITH 1;
ALTER SEQUENCE questions_id_seq
  RESTART WITH 1;
ALTER SEQUENCE answers_id_seq
  RESTART WITH 1;

INSERT INTO users (name, login, password, specialization_id)
VALUES ('teacher_name', 'teacher_login', '$2a$10$29XiXUUo1itSAHq1uYOoh.ugSsi/SeZ5RzUyn5DMqMpmMsXRc4EVa', null),
       ('teacher_name2', 'teacher_login2', '$2a$10$29XiXUUo1itSAHq1uYOoh.ugSsi/SeZ5RzUyn5DMqMpmMsXRc4EVa', null),
       ('student_name', 'student_login', '$2a$10$29XiXUUo1itSAHq1uYOoh.ugSsi/SeZ5RzUyn5DMqMpmMsXRc4EVa', null),
       ('admin_name', 'admin_login', '$2a$10$29XiXUUo1itSAHq1uYOoh.ugSsi/SeZ5RzUyn5DMqMpmMsXRc4EVa', null);

INSERT INTO roles (user_id, roles)
VALUES (1, 2),
       (2, 2),
       (3, 0),
       (4, 1);

INSERT INTO tests (description, user_id)
VALUES ('Основы Java', 1),
       ('Основы Java 2', 1),
       ('Основы Java 3', 2);

INSERT INTO questions (text, test_id)
VALUES ('Каким будет результат выполнения кода:
<pre><code>import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    String[] str = new String[] { "1", "2", "3" };

    List list = Arrays.asList(str);
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      Object object = (Object) iterator.next();
      iterator.remove();
    }
    System.out.println(list.size());
  }
}</code></pre> ', 1),
       ('Каким будет результат компиляции и запуска следующей программы?
<pre><code>public class App1 {
    public static void main(String[] args) {
        System.out.println(addToString("12345678910",'',''));
    }

    public static StringBuffer addToString(String s, char c) {
        StringBuffer b = new StringBuffer(s);
        int p = 0;
        for (int i = 1; i < b.length(); i++) {
            if (i%3 == 0) {
                b.insert(b.length()-i-p, c);
                p++;
            }
        }
        return b;
    }
}</code></pre>', 1),
       ('Назовите дизассемблер Java, который входит в стандартную поставку JDK.', 2),
       ('Что будет выведено на экран после выполнения следующего кода?
<pre><code>class Test {
    public static void main(String[] args){
        int x = 1;
        Integer y = new Integer(x);
        int [] z = {x};

        func(x, y, z);

        System.out.print(x);
        System.out.print(y);
        System.out.println(z[0]);
    }

    static void func (int x, Integer y, int[] z) {
        x++;
        y++;
        z[0]++;
    }
}</code></pre> ', 2),
       ('Что можно сказать о следующей программе?' ||
        '<pre><code>public class String {
    static String[][]String = {{"String"}};       // 1

    static {
        System.out.println(String.class);         // 2
    }

    public static void main(String[] args) {      // 3
        System.out.println(String.class);         // 4
    }
}</code></pre> ', 2),
       ('Какой будет результат выполнения данного кода?' ||
        '<pre><code>public class Main {
   static int method() {
    for (int i = 0; i < 5; i++) {
      System.out.println("i = " + i);
      try {
        if (i == 1) {
          throw new Exception();
        }
      } catch (Exception e) {
        System.out.println("Exception!");
        return i;
      } finally {
        System.out.println("Finally block");
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    System.out.println("method() returned " + method());
  }
}</code></pre> ', 3),
       ('Каким будет результат выполнения кода:' ||
        '<pre><code>package tests;

import java.util.Hashtable;

public class Test {
  public static void main(String[] args) {
    Hashtable ht = new Hashtable();
    ht.put("1", "2");
    ht.put("2", "3");
    ht.put("3", "4");
    ht.put("4", "2");

    if(ht.contains("1")){
      System.out.print("1");
    }
    if(ht.contains("2")){
      System.out.print("2");
    }
    if(ht.contains("3")){
      System.out.print("3");
    }
    if(ht.contains("4")){
      System.out.print("4");
    }
  }
}</code></pre>', 3);

INSERT INTO answers (text, correct, question_id)
VALUES ('0', false, 1),
       ('3', false, 1),
       ('Произойдет ошибка компиляции', false, 1),
       ('Произойдет ошибка времени выполнения', true, 1),
       ('Компиляция пройдет успешно и на экране напечатается "12,345,678,910" без кавычек', false, 2),
       ('Компиляция пройдет успешно и на экране напечатается 123,456,789,10 без кавычек', false, 2),
       ('Ошибка компиляции', false, 2),
       ('Компиляция пройдет успешно, но во время выполнения возникнет ArrayIndexOutOfBoundsException', true, 2),
       ('Компиляция пройдет успешно, но во время выполнения возникнет StackOverflowError', false, 2),
       ('javac', false, 3),
       ('java', false, 3),
       ('javap', true, 3),
       ('javah', false, 3),
       ('javad', false, 3),
       ('jad', false, 3),
       ('122', false, 4),
       ('111', true, 4),
       ('112', false, 4),
       ('222', false, 4),
       ('Программа напечатает java.lang.String дважды', false, 5),
       ('Программа напечатает строку, после чего завершится с ошибкой', false, 5),
       ('Программа напечатает [[Ljava.lang.String; дважды', false, 5),
       ('Возникнет ошибка компиляции', true, 5),
       ('i = 0
i = 1
Exception!
Finally block
method() returned 1', false, 6),
       ('i = 0
Finally block
i = 1
Exception!
Finally block
method() returned 1', true, 6),
       ('i = 0
i = 1
Exception!
method() returned -1', false, 6),
       ('Код не выполнится, произойдет ошибка компиляции', false, 6),
       ('Произойдет ошибка компиляции', false, 7),
       ('Произойдет ошибка времени выполнения', false, 7),
       ('1234', false, 7),
       ('Ничего из вышеперечисленного', true, 7);
