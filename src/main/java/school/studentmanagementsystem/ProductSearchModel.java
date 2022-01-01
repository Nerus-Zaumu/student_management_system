package school.studentmanagementsystem;

public class ProductSearchModel {
    Integer student_id;
    String student_name;
    String student_email;
    String student_qualification;

    public ProductSearchModel(Integer student_id, String student_name, String student_email, String student_qualification) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_qualification = student_qualification;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public String getStudent_qualification() {
        return student_qualification;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public void setStudent_qualification(String student_qualification) {this.student_qualification = student_qualification;}
}
