public class Attainment {
    private String _course;
    private String _student;
    private Integer _grade;
    public Attainment(String _course, String _student, Integer _grade) {
        this._course = _course;
        this._student = _student;
        this._grade = _grade;
    }
    public String getCourse() {
        return _course;
    }
    public String getStudent() {
        return _student;
    }
    public Integer getGrade() {
        return _grade;
    }
    
}
