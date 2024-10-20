package ex1;

import java.util.ArrayList;

public class Administration {
    private static ArrayList<Professor> professors = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();


    public static void addProfessor(Professor prof) {
        professors.add(prof);
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public static void addStudent(Student std) {
        students.add(std);
    }

}
