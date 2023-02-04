public class Student {
    private String _name;
    private String _studentNumber;

    public Student(String _name, String _studentNumber) {
        this._name = _name;
        this._studentNumber = _studentNumber;
    }
    public String getName(){
        return _name;
    }
    public String getStudentNumber(){
        return _studentNumber;
    }
}
