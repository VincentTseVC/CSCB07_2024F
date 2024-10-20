package ex1;

public class IsEligibleCSCB07 implements IisEligible{
    @Override
    public boolean isEligible(Student student) {
        return student.passedCSCA48
                && (student.cgpa >= 3.5 || student.isCSCPOSt)
                && !student.passedCSC207;
    }
}
