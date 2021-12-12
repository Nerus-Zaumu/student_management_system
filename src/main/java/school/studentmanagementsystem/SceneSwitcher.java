//package school.studentmanagementsystem;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class SceneSwitcher {
//    private Stage stage;
//    private Scene scene;
//
//   public void SwitchToLogin(ActionEvent event) throws IOException {
//       FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Login.fxml"));
//       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//       scene = new Scene(fxmlLoader.load());
//   }
//
//    public void SwitchToSignup(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Signup.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader.load());
//
//    }
//
//    public void SwitchToStudentDashboard(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("studentDashboard-view.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader.load());
//
//    }
//
//    public void SwitchToRegistration(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("studentRegistration-view.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//}
