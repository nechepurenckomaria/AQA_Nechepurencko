package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainStudents {
    public static void main(String[] args) {
        Set <Student> students = new HashSet<>(Set.of(
                new Student ("John", "A1", 1, List.of(5, 4, 3)),
                new Student("Kiara", "A1", 1, List.of(2, 3, 3)),
                new Student("Kate", "B1", 2, List.of(4, 4, 5)),
                new Student("Mike", "B1", 2, List.of(2, 2, 3)),
                new Student("Luke", "C1", 3, List.of(5, 5, 5))
        ));
        removeBadStudents (students);
        promoteStudents (students);
        int maxCourse = 0;
        for (Student student : students) {
            if (student.getCourse() > maxCourse) {
                maxCourse = student.getCourse();
            }
        }
        for (int i = 1; i <= maxCourse; i++){
            printStudents (students, i);
        }
    }
    public static void removeBadStudents (Set < Student> students){
        Iterator <Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverage() < 3) {
                iterator.remove();
            }
        }
    }
    public static void promoteStudents (Set <Student> students) {
        for (Student student : students) {
            if (student.getAverage() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }
    public static void printStudents (Set<Student> students, int course) {
        System.out.println("\n Студенты курса" + course + ":");

        for (Student student: students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}