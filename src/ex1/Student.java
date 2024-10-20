package ex1;

public class Student extends Person implements Comparable<Student> {

    double cgpa;
    boolean isCSCPOSt;
    boolean passedCSCA48;
    boolean passedCSC207;

    public Student(int sin, String name, double cgpa,
                   boolean inCSCPOSt, boolean passedCSCA48,
                   boolean passedCSC207) {

        super(sin, name);
        this.cgpa = cgpa;
        this.isCSCPOSt = inCSCPOSt;
        this.passedCSCA48 = passedCSCA48;
        this.passedCSC207 = passedCSC207;
        Administration.addStudent(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", cgpa: " + this.cgpa;
    }

    @Override
    public int compareTo(Student o) {
        int r = this.compareName(o);
        if (r == 0) {
            // return new Double(cgpa).compareTo(o.cgpa);
            if (cgpa < o.cgpa) return -1;
            if (cgpa > o.cgpa) return 1;
            return 0;
        }
        return r; // -1, 1

    }
}
