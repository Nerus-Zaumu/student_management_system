package school.studentmanagementsystem;

import javafx.scene.control.CheckBox;

public class ProductSearchModel {
    CheckBox checkbox;
    Integer student_id;
    String student_name;
    String pref_dep;
    String student_qualification;
    String email;

    public ProductSearchModel(Integer student_id, String student_name, String prefe_dep, String student_qualification, String email) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.pref_dep = prefe_dep;
        this.student_qualification = student_qualification;
        this.checkbox = new CheckBox();
        this.email = email;

    }

    public CheckBox getCheckbox() { return checkbox; }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getStudent_email() {return email;}

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_pref_dep() {
        return pref_dep;
    }

    public String getStudent_qualification() {
        return student_qualification;
    }

    public void setCheckbox(CheckBox checkbox){this.checkbox = checkbox;}

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_pref_dep(String student_email) {
        this.pref_dep = pref_dep;
    }

    public void setStudent_qualification(String student_qualification) {this.student_qualification = student_qualification;}


}
