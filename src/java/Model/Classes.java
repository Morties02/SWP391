package Model;

public class Classes {
    private int classId;
    private int lecturerId;
    private String className;
    private String EnrollKey;
    
    public Classes(){}

    public Classes(int classId, int lecturerId, String className, String enrollKey) {
        this.classId = classId;
        this.lecturerId = lecturerId;
        this.className = className;
        this.EnrollKey = enrollKey;
    }
     public Classes(int classId, int lecturerId, String className) {
        this.classId = classId;
        this.lecturerId = lecturerId;
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEnrollKey() {
        return EnrollKey;
    }

    public void setEnrollKey(String EnrollKey) {
        this.EnrollKey = EnrollKey;
    }
    
    
    
}
