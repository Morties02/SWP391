package Model;


public class Question {
//    QuestionId int primary key,
//Option1 nvarchar(max),
//Option2 nvarchar(max),
//Option3 nvarchar(max),
//Option4 nvarchar(max),
//Answer char check(Answer = 'A' or Answer = 'B' or Answer = 'C' or Answer ='D'),
    
    private int id;
    private String details;
    private String imgUrl;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    
    public Question(){}

    public Question(int id, String details, String imgUrl, String option1, String option2, String option3, String option4, String answer) {
        this.id = id;
        this.details = details;
        this.imgUrl = imgUrl;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }
    
    public Question(String details, String opt1, String opt2, String opt3, String opt4, String answ){
        this.details = details;
        this.option1 = opt1;
        this.option2 = opt2;
        this.option3 = opt3;
        this.option4 = opt4;
        this.answer = answ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
