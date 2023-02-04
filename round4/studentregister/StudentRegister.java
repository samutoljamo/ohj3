import java.util.ArrayList;

public class StudentRegister {
    private ArrayList<Student> _students;
    private ArrayList<Course> _courses;
    private ArrayList<Attainment> _attainments;
    public StudentRegister(){
        _students = new ArrayList<>();
        _courses = new ArrayList<>();
        _attainments = new ArrayList<>();
    }
    public void addStudent(Student s){
        _students.add(s);
        _students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }
    public ArrayList<Student> getStudents(){
        ArrayList<Student> copy = new ArrayList<Student>(_students);
        return copy;
    }

    public void addCourse(Course c){
        _courses.add(c);
        _courses.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
    }
    
    public ArrayList<Course> getCourses(){
        ArrayList<Course> copy = new ArrayList<>(_courses);
        return copy;
    }


    public void addAttainment(Attainment c){
        _attainments.add(c);
    }

    public void printStudentAttainments(String studentNumber){
        printStudentAttainments(studentNumber, "");
    }

    public void printStudentAttainments(String studentNumber, String order){
        Student s = null;
        for (Student student : _students) {
            if(student.getStudentNumber() == studentNumber){
                s = student;
                break;
            }
        }
        if(s == null){
            System.out.format("Unknown student number: %s%n", studentNumber);
            return;
        }
        System.out.format("%s (%s):%n", s.getName(), s.getStudentNumber());

        ArrayList<Attainment> copy = new ArrayList<>();
        for (Attainment attainment : _attainments) {
            if(attainment.getStudent().compareTo(studentNumber) == 0){
                copy.add(attainment);
            }
        }

        switch (order) {
            case "by name":
                copy.sort((a1, a2) -> {
                    Course a = null;
                    Course b = null;
                    for (Course c : _courses) {
                        if(c.getCode().equals(a1.getCourse())){
                            a = c;
                            if(b != null)
                                break;
                        }

                        if(c.getCode().equals(a2.getCourse())){
                            b = c;
                            if(a != null)
                                break;
                        }
                    }
                    return a.getName().compareTo(b.getName());
                });
                break;
            case "by code":
                copy.sort((a1, a2) -> a1.getCourse().compareTo(a2.getCourse()));
                break;
            default:
                break;
        }
        for(Attainment a : copy){
            Course course = null;
            for (Course c : _courses) {
                if(c.getCode().compareTo(a.getCourse()) == 0){
                    course = c;
                    break;
                }
            }
            System.out.format("  %s %s: %s%n", a.getCourse(), course.getName(), a.getGrade());
        }
    }
}
