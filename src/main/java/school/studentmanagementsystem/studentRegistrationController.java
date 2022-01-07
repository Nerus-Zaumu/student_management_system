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
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import org.w3c.dom.Document;
import com.itextpdf.text.Document;



import org.w3c.dom.events.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class studentRegistrationController {



    //

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;


//
//@
//
//


    ObservableList<String> pr_dep = FXCollections.observableArrayList("Civil Engineering", "Rural Engineering", "Town Planning", "Land Surveying");
  //      ObservableList<String> countries = FXCollections.observableArrayList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine");
  //  ObservableList<String> regions = FXCollections.observableArrayList("Far North", "North", "Adamaoua", "Centre", "East", "West", "Littoral", "South", "South West", "NorthWest");
    //ObservableList<String> divisions = FXCollections.observableArrayList("Fako", "Meme", "Ndian", "Manyu", "Lebialem", "Kupe Manenguba", "Boyo", "Bui", "Donga-Mantung", "Menchum", "Mezam", "Momo", "Ngo-ketunjia", "Bamboutos", "Haut-Nkam", "Hauts-Plateaux", "Koung-Khi", "Menoua", "Mifi", "Nde", "Noun", "Moungo", "Nkam", "Sanaga-Maritime", "Wouri", "Dja-et_Lobo", "Mvila", "Ocean", "Vallee-du-Ntem", "Boumba-et-Ngoko", "Haut-Nyong", "Kadey", "Lom-et-Djerem", "Haute-Sanaga", "Lekie", "Mbam-et-Inoubou", "Mbam-et-Kim", "Mefou-et-Afamba", "Mefou-et-Akono", "Mfoundi", "Nyong-et-mfoumou", "Nyong-et-So'o", "Benoue", "Faro", "Mayo-Louti", "Mayo-Rey", "Diamare", "Logone-et-Chari", "Mayo-Danay", "Mayo-Kani", "Mayo-Sava", "Mayo-Tsanaga", "Djerem", "Fara-etDeo", "Mayo-Banyo", "Mbere", "Vina");

//    @FXML
//    private ComboBox<String> region;
//    @FXML
//    ComboBox<String> division;
//
//    ObservableList<String> countryLoad = FXCollections.observableArrayList(countries);
//    ObservableList<String> regionLoad = FXCollections.observableArrayList(regions);
//    ObservableList<String> divisionLoad = FXCollections.observableArrayList(divisions);
//
    //@Override
   // public void initialize(URL url, ResourceBundle resourceBundle){
      //  pref_dep_id.setItems(pr_dep);

//        country.setItems(countryLoad);
//        region.setItems(regionLoad);
//        division.setItems(divisionLoad);


    @FXML
    private TextField email_id;
    @FXML
    private PasswordField password_id;
    @FXML
    private Label type_id;
    @FXML
    private Label type2_id;
    @FXML
    private TextField f_name_id;
    @FXML
    private TextField matricule_id;
    @FXML
    private TextField password1_id;
    @FXML
    private TextField password2_id;
    @FXML
    private static TextField email2_id;
    @FXML
    private TextField l_name_id;
    @FXML
    private TextField placeOfBirth;
    @FXML
    private TextField mothers_name_id;
    @FXML
    private TextField fathers_name_id;
    @FXML
    private TextField sex_id;
    @FXML
    private DatePicker dateOfBirth_id;
    @FXML
    private TextField region_id;
    @FXML
    private TextField division_id;
    @FXML
    private TextField country_id;
    @FXML
    private TextField m_status_id;
    @FXML
    private TextField p_address_id;

    @FXML
    private TextField pref_dep_id;

    @FXML
    private Button login_button;


    @FXML
    private TextField address_id;
    @FXML
    private TextField qualification_id;
    public String get_name(){
        System.out.println("i am in the get_name function");
        String user_name = " ";
        boolean failure = true;



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/institution_database", "root", "willywillywils");
            PreparedStatement pst = con.prepareStatement("select * from student where mothers_address = ?");
            pst.setString(1, email_id.getText());
            ResultSet rs = pst.executeQuery();


     if(rs.next()) {

         String fname = rs.getString("f_name");
         String lname = rs.getString("l_name");
         user_name = fname + " " +lname;
     }




        } catch (Exception ee) {
            System.out.println("soo soo baaaaaaaad");
            System.out.println(ee);
        }




        System.out.println(user_name);
        return user_name;

    }

        public int get_type() {
//        Document doc = new Document();
        int u;

        if (type_id.getText().equals("Admin Login")) {
            u = 1;
        } else {
            u = 0;
        }
        return u;
    }

    public void switch_class() throws IOException {
        System.out.println("I am cliked");


        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("productsearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registration Form");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //
    public void change() {
        if (get_type() == 1) {
            type_id.setText("Student Login");
            type2_id.setText("Log in As Admin");
        } else {
            type_id.setText("Admin Login");
            type2_id.setText("Log in As Student");
        }

    }
    public void SwitchToReports(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Reports.fxml")));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("studentRegistration-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void SwitchToRegistration(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentRegistration-view.fxml")));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("studentRegistration-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void SwitchToLogin(ActionEvent event) throws IOException {
        String name = "Login.fxml";

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToSignup(ActionEvent event) throws IOException {
        try {
            register();
        } catch (Exception u) {
            System.out.println("are we together");
        }
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signup.fxml")));
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("Signup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean testValidation(String type) {
        Alert u = new Alert(Alert.AlertType.NONE);
        String userText = email_id.getText();
        String pwdText = password_id.getText();
        boolean failure = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/institution_database", "root", "willywillywils");
            PreparedStatement pst = con.prepareStatement("select * from users where email is not null");
            ResultSet rs = pst.executeQuery();


            while (rs.next() && failure) {
                System.out.println(rs.getString("email"));

                String name = rs.getString("email");
                String ppd = rs.getString("passwords");
                String typ = rs.getString("typ");
                System.out.println(name + " " + ppd + " " + typ + "     " + userText + " " + type + " " + pwdText + "\n");

                if (name.equals(userText) && pwdText.equals(ppd) && type.equals(typ)) {
                    failure = false;
                    u.setAlertType(Alert.AlertType.CONFIRMATION);
                    u.setContentText("Successful Login");
                    u.show();
                } else {
                    if (name.equals(userText)) {
                        u.setAlertType(Alert.AlertType.ERROR);
                        u.setContentText("Failure");
                        u.show();
                    }

                }
            }

        } catch (Exception ee) {
            System.out.println("soo soo baaaaaaaad");
            System.out.println(ee);
        }
        return failure;
    }

    public void SwitchToStudentDashboard(ActionEvent event) throws IOException {
        String username = get_name();
        boolean success;
        String name = "studentDashboard-view.fxml";
        String type = "Stud";
        if (get_type() == 1) {
            name = "AdminDashboard.fxml";
            type = "Admin";
        }
        System.out.println(type);
        success = !testValidation(type);
        if (success) {
            if(type == "Admin"){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
            }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource(name));

                root = loader.load();
                studentDashboardController studentDashboard = loader.getController();
                studentDashboard.displayStudentName(username);
            }


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("couldn't get in");
        }
//        FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("studentDashboard-view.fxml"));


    }

    //The main registration program starts here
    public void register() {
        System.out.println("how are you today");
        LocalDate myDate = dateOfBirth_id.getValue();
        System.out.println(myDate.toString());

        DatabaseConnection con = new DatabaseConnection();


        String fi_name = f_name_id.getText();
        String last_name = l_name_id.getText();
        String place = placeOfBirth.getText();
        String qualification = qualification_id.getText();
        String sex = sex_id.getText();
        String marital_stats = m_status_id.getText();
        String mothers_name = mothers_name_id.getText();
        String fathers_name = fathers_name_id.getText();
        String m_address = email_id.getText();
        String f_address = p_address_id.getText();
        String address = address_id.getText();
        String region = region_id.getText();
        String division = division_id.getText();
        String country = country_id.getText();
        String dp_id = pref_dep_id.getText();

        int special_code = 0000;


        String addStAcc = "INSERT INTO student(f_name, l_name, place_of_birth, region_of_origin, address, marital_status, qualification, sex, mothers_name, fathers_name, division_of_origin, date_of_birth, mothers_address, fathers_address, pref_dep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection con_student = con.getConnection();
        Alert a = new Alert(Alert.AlertType.NONE);


        try {
            System.out.println("how are you today");
            PreparedStatement insert = con_student.prepareStatement(addStAcc);


            insert.setString(1, fi_name);
            insert.setString(2, last_name);
            insert.setString(3, place);
            insert.setString(4, region);
            insert.setString(5, address);
            insert.setString(6, marital_stats);
            insert.setString(7, qualification);
            insert.setString(8, sex);
            insert.setString(9, mothers_name);
            insert.setString(10, fathers_name);
            insert.setString(11, division);
            insert.setDate(12, Date.valueOf(myDate));
            insert.setString(13, m_address);
            insert.setString(14, f_address);
            insert.setString(15, dp_id);

            int uuuu = insert.executeUpdate();

            PreparedStatement get_stu_id = con_student.prepareStatement("SELECT * from student");
            ResultSet studs = get_stu_id.executeQuery();
            boolean found = false;
            while (studs.next() && !found) {
                String firsName = studs.getString("f_name");
                String secondName = studs.getString("l_name");
                if (firsName.equals(fi_name) && secondName.equals(last_name)) {
                    special_code = studs.getInt("stu_id");
                }
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Successfull Registration your special code is " + special_code);
                a.show();


            }


            System.out.println("successfll registration");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An exception was caught");
        }


    }

    public void View_registered_students(ActionEvent event) throws IOException {


        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("productsearch.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("productsearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sign_up(ActionEvent event) throws IOException {

        System.out.println("I am right in here");
        String special_code = matricule_id.getText();
        String email = email2_id.getText();
        String pas1 = password1_id.getText();
        String pas2 = password2_id.getText();
        String pas = "0";
        System.out.println(email + pas1 + pas2);


        Alert u = new Alert(Alert.AlertType.NONE);
        if (pas1.equals(pas2)) {
            pas = pas1;


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/institution_database", "root", "willywillywils");
                PreparedStatement pst = con.prepareStatement("select * from users");
                PreparedStatement update_users = con.prepareStatement("UPDATE users SET passwords = ? WHERE user_id = ?");
                ResultSet rs = pst.executeQuery();

                boolean failure = true;
                while (rs.next() && failure) {

                    String emails = rs.getString("email");
                    String user_id = rs.getString("user_id");
                    System.out.println(special_code + "  " + email + email.equals(emails) + special_code.equals(user_id));


                    if (special_code.equals(user_id) && emails.equals(email)) {
                        update_users.setInt(2, Integer.parseInt(user_id));
                        update_users.setString(1, pas);
                        int uvw = update_users.executeUpdate();

                        u.setAlertType(Alert.AlertType.CONFIRMATION);
                        u.setContentText("successfull!!!");
                        u.show();
                        failure = false;

                    }


                }

            } catch (Exception ee) {
                System.out.println("soo soo bad");
                System.out.println(ee);
            }


        }


    }


}
