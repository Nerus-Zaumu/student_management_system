package school.studentmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductSearchController implements Initializable {

    @FXML
    private Pane verifyAdmission_id;
    @FXML
    private Label change_name;
    @FXML
    private TableView<ProductSearchModel> productTableView;
    @FXML
    private TableColumn<ProductSearchModel, Integer> ID_id;
    @FXML
    private TableColumn<ProductSearchModel, Integer> email_id;
    @FXML
    private TableColumn<ProductSearchModel, String> name_id;
    @FXML
    private TableColumn<ProductSearchModel, String> prefe_dep_id;
    @FXML
    private TableColumn<ProductSearchModel, String> qualification_id;
    @FXML
    private TableColumn<ProductSearchModel, CheckBox> checkboxID;


    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    public ComboBox<String> comboBox_id, comboBox_id1, comboBox_id2;


    ObservableList<String> cycleList = FXCollections.observableArrayList("Basic T.C", " Ordinary T.C", "Higher T.C");

    ObservableList<String> list = FXCollections.observableArrayList("Civil Engineering", "Rural Engineering", "Town Planning", "Land Surveying");
    ObservableList<ProductSearchModel> productSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
        comboBox_id.setItems(cycleList);
        comboBox_id1.setItems(list);
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String productViewQuery = "select stu_id, f_name,l_name, pref_dep, qualification, mothers_address from student where stu_id > 13 and registered is false";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(productViewQuery);



            while(queryOutput.next()){
                int student_id = queryOutput.getInt( "stu_id");
                String student_name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
                String student_email = queryOutput.getString("mothers_address");
                String student_pref_dep = queryOutput.getString("pref_dep");
                String student_qualification = queryOutput.getString("qualification");


                //populate the observable list
                productSearchModelObservableList.add(new ProductSearchModel(student_id, student_name, student_pref_dep, student_qualification, student_email));
            }


            //PropertyValueFactory corresponds to the new ProductSearchModel fields
            //The table column is the one you annotate above
            ID_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            name_id.setCellValueFactory(new PropertyValueFactory<>("student_name"));
            email_id.setCellValueFactory(new PropertyValueFactory<>("student_email"));
            prefe_dep_id.setCellValueFactory(new PropertyValueFactory<>("student_pref_dep"));
            qualification_id.setCellValueFactory(new PropertyValueFactory<>("student_qualification"));
            checkboxID.setCellValueFactory(new PropertyValueFactory<>("checkbox"));

            productTableView.setItems(productSearchModelObservableList);

        } catch (SQLException e) {
            Logger.getLogger(ProductSearchController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();

        }
    }







    public void Back_to_admin(ActionEvent event) throws IOException{



        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminDashboard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("productsearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void add_student(ActionEvent event) {//given  a user id, dep_id, cycle_id and user type
        System.out.println(list.get(0));
        System.out.println(cycleList.get(2));
        String cycle = comboBox_id.getValue();
        String dept = comboBox_id1.getValue();
        int stuDepId = 0;
        int stuCycId = 0;

        int i = 0;

        while(i<4){

            if(dept.equals(list.get(i))){
                stuDepId = i+1;

            }
            i=i+1;

        }
        i=0;
        while(i<3){
            if(cycle.equals(cycleList.get(i))){
                stuCycId = i+1;

            }
            i = i + 1;

        }

        String student_class = String.valueOf(stuCycId) + stuDepId +  "200";



        if(stuCycId != 0 && stuDepId !=0){
            ObservableList<ProductSearchModel> studentsToAdd = FXCollections.observableArrayList();
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            try{
                for(ProductSearchModel aStudent : productSearchModelObservableList){
                    if(aStudent.getCheckbox().isSelected()){
                        studentsToAdd.add(aStudent);
                        Integer stud_id = aStudent.getStudent_id();
                        String stud_email = aStudent.getStudent_email();

                        //String stud_email = aStudent.getStudent_email();
                        //String name = aStudent.getStudent_name();
                        // change_name.setText(name);
                        //String add_stud_to_class = "INSERT INTO class(cycle_id, dept_id, stu_id) values (?,?,?)";
                        String enroll_query = "INSERT INTO enrolment values (?, ?)";
                        String add_student_query = "INSERT INTO users( user_id, typ, email) VALUES (?,?,?)";
                        String change_reg_status = "UPDATE student SET registered = ?, user_id = ?, cycle_id = ?, dep_id = ?, student_class = ? WHERE stu_id = ?";

                        try{
                            PreparedStatement insert = connectDB.prepareStatement(add_student_query);
                            PreparedStatement statement = connectDB.prepareStatement(change_reg_status);
                            PreparedStatement enroll = connectDB.prepareStatement(enroll_query);



                          //  PreparedStatement adToClas = connectDB.prepareStatement(add_stud_to_class);

                            statement.setBoolean(1, true);
                            statement.setInt(2,stud_id);
                            statement.setInt(3, stuCycId);
                            statement.setInt(4, stuDepId);
                            statement.setString(5, student_class);
                            statement.setInt(6,stud_id);

                            insert.setInt(1, stud_id);
                            insert.setString(2, "Stud");
                           insert.setString(3, stud_email);

                            enroll.setInt(1, Integer.parseInt(student_class));
                            enroll.setInt(2, stud_id);

//                            adToClas.setInt(1,stuCycId);
//                            adToClas.setInt(2,stuDepId);
//                            adToClas.setInt(3,stud_id);



                           // int ppp = insert.executeUpdate();
                            int uuu = statement.executeUpdate();
                            int vvv = enroll.executeUpdate();
                            //int fff = adToClas.executeUpdate();
                            //   productTableView.getItems().removeAll(productTableView.getSelectionModel().getSelectedItem());


                        } catch (SQLException e) {
                            Logger.getLogger(ProductSearchController.class.getName()).log(Level.SEVERE, null, e);
                            e.printStackTrace();

                        }
                    }
                }


                productSearchModelObservableList.removeAll(studentsToAdd);






            }
            catch (Exception e){

                System.out.println(e);
                System.out.println("there is a big problem here");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please chose department and Cycele");
            alert.show();
        }





    }
}