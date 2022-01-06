package school.studentmanagementsystem;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import school.studentmanagementsystem.studentRegistrationController;

import java.net.URL;
import java.util.ResourceBundle;

public class studentDashboardController  {
    @FXML
    private Label stud_name_id;

    public void displayStudentName(String name){
        stud_name_id.setText(name);
    }

}
