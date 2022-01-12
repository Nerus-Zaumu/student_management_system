package school.studentmanagementsystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import school.studentmanagementsystem.studentRegistrationController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class studentDashboardController  {
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Label stud_name_id;
    private Label stud_notification_id;
    private Label stud_department_id;

    public void displayStudentName(String name){
        stud_name_id.setText(name);
    }
    public void displayStudentNotification(String notification){
        stud_notification_id.setText(notification);
    }
    public void displayStudentClass(String classs){
        stud_department_id.setText(classs);

    }

    public void switchToSignup(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Signup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
