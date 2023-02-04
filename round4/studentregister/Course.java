public class Course {
    private String _code;
    private String _name;
    private Integer _credits;
    public String getCode() {
        return _code;
    }
    public String getName() {
        return _name;
    }
    public Integer getCredits() {
        return _credits;
    }
    public Course(String _code, String _name, Integer _credits) {
        this._code = _code;
        this._name = _name;
        this._credits = _credits;
    }
    

}
