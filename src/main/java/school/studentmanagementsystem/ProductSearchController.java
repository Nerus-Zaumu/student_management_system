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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    ObservableList<ProductSearchModel> productSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String productViewQuery = "select stu_id, f_name, mothers_address, qualification from student where mothers_address is not null;";

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




    public void SwitchToRegistered(ActionEvent event) throws IOException {
        String name = "productsearch.fxml";

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void add_student(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            ProductSearchModel one_stud = productTableView.getSelectionModel().getSelectedItem();


            if(one_stud==null){
                change_name.setText("no selection");
            }
            else{
                Integer name = one_stud.getStudent_id();
                change_name.setText(name.toString());
            }
        }
        catch (Exception e){

            System.out.println(e);
            System.out.println("there is a big problem here");
        }
    }
}