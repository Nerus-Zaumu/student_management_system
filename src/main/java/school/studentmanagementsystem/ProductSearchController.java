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
    private TableColumn<ProductSearchModel, String> name_id;
    @FXML
    private TableColumn<ProductSearchModel, String> email_id;
    @FXML
    private TableColumn<ProductSearchModel, String> qualification_id;


    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    public ComboBox<String> comboBox_id;

    ObservableList<String> list = FXCollections.observableArrayList("Civil Engineering", "Rural Engineering", "Land Surveying", "Town Planning");
    ObservableList<ProductSearchModel> productSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
       // comboBox_id.setItems(list);
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String productViewQuery = "select stu_id, f_name, mothers_address, qualification from student where stu_id > 13 and registered is false";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(productViewQuery);



            while(queryOutput.next()){
                int student_id = queryOutput.getInt( "stu_id");
                String student_name = queryOutput.getString("f_name");
                String student_email = queryOutput.getString("mothers_address");
                String student_qualification = queryOutput.getString("qualification");

                //populate the observable list
                productSearchModelObservableList.add(new ProductSearchModel(student_id, student_name, student_email, student_qualification));
            }

            //PropertyValueFactory corresponds to the new ProductSearchModel fields
            //The table column is the one you annotate above
            ID_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            name_id.setCellValueFactory(new PropertyValueFactory<>("student_name"));
            email_id.setCellValueFactory(new PropertyValueFactory<>("student_email"));
            qualification_id.setCellValueFactory(new PropertyValueFactory<>("student_qualification"));
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


    public void add_student(javafx.scene.input.MouseEvent mouseEvent) {//given  a user id, dep_id, cycle_id and user type
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try{
            ProductSearchModel one_stud = productTableView.getSelectionModel().getSelectedItem();


                Integer stud_id = one_stud.getStudent_id();
                String stud_email = one_stud.getStudent_email();
                String name = one_stud.getStudent_name();
               // change_name.setText(name);
                String add_student_query = "INSERT INTO users( user_id, typ, email) VALUES (?,?,?)";
                String change_reg_status = "UPDATE student SET registered = ? WHERE stu_id = ?";

                try{
                    PreparedStatement insert = connectDB.prepareStatement(add_student_query);
                    PreparedStatement statement = connectDB.prepareStatement(change_reg_status);

                    statement.setBoolean(1, true);
                    statement.setInt(2,stud_id);

                    insert.setInt(1, stud_id);
                    insert.setString(2, "Stud");
                    insert.setString(3, stud_email);
                    int ppp = insert.executeUpdate();
                    int uuu = statement.executeUpdate();
                    productTableView.getItems().removeAll(productTableView.getSelectionModel().getSelectedItem());


                } catch (SQLException e) {
                    Logger.getLogger(ProductSearchController.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();

                }

        }
        catch (Exception e){

            System.out.println(e);
            System.out.println("there is a big problem here");
        }
    }
}