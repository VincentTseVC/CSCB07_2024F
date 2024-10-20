package ex1;

import java.util.ArrayList;

public class Course {
    String code;
    Professor professor;
    ArrayList<Student> students;

    IisEligible takingCondition;

    // Driver:
    //      Course cscb07 = new Course("CSCB07", vc, IsEligibleCSCB07);
    //      cscb07.isEligibile(nioki);
    public Course(String code, Professor professor, IisEligible takingCondition) {
        this.code = code;
        this.professor = professor;
        this.students = new ArrayList<>();

        this.takingCondition = takingCondition;

        Administration.addCourse(this);

    }

    public boolean isEligibile(Student student) {
        return this.takingCondition.isEligible(student);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Person)) return false;

        Course other = (Course) o;
        return this.code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }



    public void addStudent(Student student) {
        if (this.isEligibile(student) && !this.students.contains(student))
            this.students.add(student);
    }

    public void displayInfo() {
        System.out.println(String.format("ex1.Course code: %s", this.code));
        System.out.println(String.format("ex1.Professor: %s", this.professor.toString()));
        System.out.println("Students: ");
        this.students.sort(null);
        for (Student s: this.students)
            System.out.println(String.format("\t%s", s.toString()));
    }
}
