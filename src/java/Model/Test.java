
package Model;

public class Test {
    private int TestId;
    private int ClassId;
    private String TestName;
    private String EnrollmentKey;
    
    public Test(){}

    public Test(int TestId, int ClassId,String testName, String EnrollmentKey) {
        this.TestId = TestId;
        this.ClassId = ClassId;
        this.TestName = testName;
        this.EnrollmentKey = EnrollmentKey;
    }
    

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int ClassId) {
        this.ClassId = ClassId;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String TestName) {
        this.TestName = TestName;
    }

    
    public String getEnrollmentKey() {
        return EnrollmentKey;
    }

    public void setEnrollmentKey(String EnrollmentKey) {
        this.EnrollmentKey = EnrollmentKey;
    }
    
    
}
