import java.util.Comparator;

public class Attainment implements Comparable<Attainment>{
    private String courseCode;
    private String studentNumber;
    private int grade;

    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment o1, Attainment o2) {
            int result = o1.courseCode.compareTo(o2.courseCode);
            if(result == 0){
                result = o2.grade - o1.grade;
            }
            return result;
        }
    };

    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment o1, Attainment o2) {
            int result = o1.courseCode.compareTo(o2.courseCode);
            if(result == 0){
                result = o1.studentNumber.compareTo(o2.studentNumber);
            }
            return result;
        }
    };

    public Attainment(String courseCode, String studentNumber, int grade){
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getGrade() {
        return grade;
    }

    public String toString(){
        return String.format("%s %s %d", courseCode, studentNumber, grade);
    }

    @Override
    public int compareTo(Attainment o) {
        int result = this.studentNumber.compareTo(o.studentNumber);
        if(result == 0){
            result = this.courseCode.compareTo(o.courseCode);
        }
        return result;
    }
    
}
