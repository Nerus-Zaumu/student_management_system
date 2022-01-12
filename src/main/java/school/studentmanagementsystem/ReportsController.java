package school.studentmanagementsystem;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ReportsController extends Application {
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;
    @FXML
    private Label one,two,three,four,five,six,seven;

    private String Cycle_stats_total, Cycle_stats_male, Cycle_stats_female, Class_stats_total, Class_stats_male, Class_stats_female, Dep_stats_total, Dep_stats_male, Dep_stats_female;


    public void Registered_Students(ActionEvent event) throws IOException, SQLException, DocumentException {



        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String productViewQuery = "select  student.l_name, student.f_name, student.sex, class.class_name as Class_Atribute \n" +
                "from student\n" +
                "join class\n" +
                "on class.class_id = student.student_class\n" +
                "where student.registered is not null and student.mothers_address is not null;";

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(productViewQuery);
        /* Step-2: Initialize PDF documents - logical objects */
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Registered_Students.pdf"));
        my_pdf_report.open();

        String paragraph = "                                 LIST OF REGISTERED STUDENTS\n\n\n\n\n";
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(4);
        //create a cell object
        PdfPCell table_cell;
        table_cell=new PdfPCell(new Phrase("No"));

        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("l_name"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Sex"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Class Name"));
        my_report_table.addCell(table_cell);
        int no=0;
        while (queryOutput.next()) {
            no = no + 1;
            String num = String.valueOf(no);
            table_cell=new PdfPCell(new Phrase(num));
            my_report_table.addCell(table_cell);

            String name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
            table_cell=new PdfPCell(new Phrase(name));



            my_report_table.addCell(table_cell);
            String manager_id=queryOutput.getString("sex");
            table_cell=new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id=queryOutput.getString("Class_Atribute");
            table_cell=new PdfPCell(new Phrase(location_id));
            my_report_table.addCell(table_cell);

            System.out.println(no);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();


        one.setText("Registered Students");
    }


    public void studentperdepartment(ActionEvent event) throws IOException, SQLException, DocumentException {

        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Studentperdepartment.pdf"));

        my_pdf_report.open();
        String paragraph = "                                 \n                      LIST OF STUDENTS PER DEPARTMENT" ;
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        for(int i=1; i<=3; i++){
            for(int j=1; j<=4; j++){

                String department_code = j + String.valueOf(i) + "200";
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();

                String productViewQuery = "select  student.l_name, student.f_name, student.sex, class.class_code as Class_Atribute, class.class_name  \n" +
                        "from student\n" +
                        "join class\n" +
                        "on class.class_id = student.student_class\n" +
                        "where student.registered is not null and student.mothers_address is not null  and student_class = " + department_code;




                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(productViewQuery);
                /* Step-2: Initialize PDF documents - logical objects */
                /* Step-2: Initialize PDF documents - logical objects */
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                PdfPCell table_cell;
                System.out.println(queryOutput.toString());
                if(queryOutput.next()){
                    String dep_name = "\n\n\n" + queryOutput.getString("class_name").toUpperCase() ;
                    Paragraph para_ob = new Paragraph(dep_name);
                    my_pdf_report.add(para_ob);

                    //create a cell object

                    table_cell=new PdfPCell(new Phrase("No"));

                    my_report_table.addCell(table_cell);
                    table_cell=new PdfPCell(new Phrase("Name"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Sex"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Class code"));
                    my_report_table.addCell(table_cell);
                }




                int no=0;
                try{
                    String l_na = queryOutput.getString("l_name");
                    do {
                        Paragraph para_ob = new Paragraph(" \n");
                        my_pdf_report.add(para_ob);
                        no = no + 1;
                        String num = String.valueOf(no);
                        table_cell=new PdfPCell(new Phrase(num));
                        my_report_table.addCell(table_cell);

                        String name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
                        table_cell=new PdfPCell(new Phrase(name));



                        my_report_table.addCell(table_cell);
                        String manager_id=queryOutput.getString("sex");
                        table_cell=new PdfPCell(new Phrase(manager_id));
                        my_report_table.addCell(table_cell);
                        String location_id=queryOutput.getString("Class_Atribute");
                        table_cell=new PdfPCell(new Phrase(location_id));
                        my_report_table.addCell(table_cell);

                        System.out.println(no);
                    } while (queryOutput.next());
                }
                catch (SQLException uu){

                }


                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);



            }

        }
        my_pdf_report.close();


        six.setText("Students per department");
    }


    public void Studentpercycle(ActionEvent event) throws IOException, SQLException, DocumentException {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String productViewQuery = "select f_name, l_name, sex, qualification from student where stu_id > 13 and registered is true";

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(productViewQuery);
        /* Step-2: Initialize PDF documents - logical objects */
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Studentpercycle.pdf"));
        my_pdf_report.open();

        String paragraph = "FIRST REPORT\n";
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(4);
        //create a cell object
        PdfPCell table_cell;
        table_cell=new PdfPCell(new Phrase("f_name"));

        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("l_name"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Sex"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Qualification"));
        my_report_table.addCell(table_cell);
        while (queryOutput.next()) {
            String dept_id = queryOutput.getString("f_name");
            table_cell=new PdfPCell(new Phrase(dept_id));

            my_report_table.addCell(table_cell);
            String dept_name=queryOutput.getString("l_name");
            table_cell=new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id=queryOutput.getString("sex");
            table_cell=new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id=queryOutput.getString("qualification");
            table_cell=new PdfPCell(new Phrase(location_id));
            my_report_table.addCell(table_cell);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();


        five.setText("Students Per Cycle");
    }

    public void femaleStudentsPerClass(ActionEvent event) throws IOException, SQLException, DocumentException {


        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("femaleStudentsPerClass.pdf"));

        my_pdf_report.open();
        String paragraph = "                                 \n                      LIST OF FEMALE STUDENTS PER CLASS" ;
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        for(int i=1; i<=3; i++){
            for(int j=1; j<=4; j++){
                String department_code = j + String.valueOf(i) + "200";
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();

                String productViewQuery = "select  student.l_name, student.f_name, student.sex, class.class_code as Class_Atribute, class.class_name  \n" +
                        "from student\n" +
                        "join class\n" +
                        "on class.class_id = student.student_class\n" +
                        "where student.registered is not null and student.mothers_address is not null and student.sex like ('f%') and student_class = " + department_code;




                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(productViewQuery);
                /* Step-2: Initialize PDF documents - logical objects */
                /* Step-2: Initialize PDF documents - logical objects */
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                PdfPCell table_cell;
                System.out.println(queryOutput.toString());
                if(queryOutput.next()){
                    String dep_name = "\n\n\n" + queryOutput.getString("class_name").toUpperCase() ;
                    Paragraph para_ob = new Paragraph(dep_name);
                    my_pdf_report.add(para_ob);

                    //create a cell object

                    table_cell=new PdfPCell(new Phrase("No"));

                    my_report_table.addCell(table_cell);
                    table_cell=new PdfPCell(new Phrase("Name"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Sex"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Class code"));
                    my_report_table.addCell(table_cell);
                }




                int no=0;
                try{
                    String l_na = queryOutput.getString("l_name");
                    do {
                        Paragraph para_ob = new Paragraph(" \n");
                        my_pdf_report.add(para_ob);
                        no = no + 1;
                        String num = String.valueOf(no);
                        table_cell=new PdfPCell(new Phrase(num));
                        my_report_table.addCell(table_cell);

                        String name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
                        table_cell=new PdfPCell(new Phrase(name));



                        my_report_table.addCell(table_cell);
                        String manager_id=queryOutput.getString("sex");
                        table_cell=new PdfPCell(new Phrase(manager_id));
                        my_report_table.addCell(table_cell);
                        String location_id=queryOutput.getString("Class_Atribute");
                        table_cell=new PdfPCell(new Phrase(location_id));
                        my_report_table.addCell(table_cell);

                        System.out.println(no);
                    } while (queryOutput.next());
                }
                catch (SQLException uu){

                }


                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);



            }

        }
        my_pdf_report.close();

        four.setText("Female Students per class");
    }

    public void male_students_per_class(ActionEvent event) throws IOException, SQLException, DocumentException {
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("male_students_per_class.pdf"));

        my_pdf_report.open();
        String paragraph = "                                 \n                      LIST OF MALE STUDENTS PER CLASS" ;
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        for(int i=1; i<=3; i++){
            for(int j=1; j<=4; j++){
                String department_code = j + String.valueOf(i) + "200";
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();

                String productViewQuery = "select  student.l_name, student.f_name, student.sex, class.class_code as Class_Atribute, class.class_name  \n" +
                        "from student\n" +
                        "join class\n" +
                        "on class.class_id = student.student_class\n" +
                        "where student.registered is not null and student.mothers_address is not null and student.sex not like ('f%') and student_class = " + department_code;




                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(productViewQuery);
                /* Step-2: Initialize PDF documents - logical objects */
                /* Step-2: Initialize PDF documents - logical objects */
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                PdfPCell table_cell;
                System.out.println(queryOutput.toString());
                if(queryOutput.next()){
                    String dep_name = "\n\n\n" + queryOutput.getString("class_name").toUpperCase() ;
                    Paragraph para_ob = new Paragraph(dep_name);
                    my_pdf_report.add(para_ob);

                    //create a cell object

                    table_cell=new PdfPCell(new Phrase("No"));

                    my_report_table.addCell(table_cell);
                    table_cell=new PdfPCell(new Phrase("Name"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Sex"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Class code"));
                    my_report_table.addCell(table_cell);
                }




                int no=0;
                try{
                    String l_na = queryOutput.getString("l_name");
                    do {
                        Paragraph para_ob = new Paragraph(" \n");
                        my_pdf_report.add(para_ob);
                        no = no + 1;
                        String num = String.valueOf(no);
                        table_cell=new PdfPCell(new Phrase(num));
                        my_report_table.addCell(table_cell);

                        String name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
                        table_cell=new PdfPCell(new Phrase(name));



                        my_report_table.addCell(table_cell);
                        String manager_id=queryOutput.getString("sex");
                        table_cell=new PdfPCell(new Phrase(manager_id));
                        my_report_table.addCell(table_cell);
                        String location_id=queryOutput.getString("Class_Atribute");
                        table_cell=new PdfPCell(new Phrase(location_id));
                        my_report_table.addCell(table_cell);

                        System.out.println(no);
                    } while (queryOutput.next());
                }
                catch (SQLException uu){

                }


                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);



            }

        }
        my_pdf_report.close();




        three.setText("Male Students Per class");
    }

    public void Students_per_Class(ActionEvent event) throws IOException, SQLException, DocumentException {



        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Students_per_Class.pdf"));

        my_pdf_report.open();
        String paragraph = "                                 \n                      LIST OF STUDENTS PER CLASS" ;
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        for(int i=1; i<=3; i++){
            for(int j=1; j<=4; j++){
                String department_code = j + String.valueOf(i) + "200";
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();

                String productViewQuery = "select  student.l_name, student.f_name, student.sex, class.class_code as Class_Atribute, class.class_name  \n" +
                        "from student\n" +
                        "join class\n" +
                        "on class.class_id = student.student_class\n" +
                        "where student.registered is not null and student.mothers_address is not null  and student_class = " + department_code;




                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(productViewQuery);
                /* Step-2: Initialize PDF documents - logical objects */
                /* Step-2: Initialize PDF documents - logical objects */
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(4);
                PdfPCell table_cell;
                System.out.println(queryOutput.toString());
                if(queryOutput.next()){
                    String dep_name = "\n\n\n" + queryOutput.getString("class_name").toUpperCase() ;
                    Paragraph para_ob = new Paragraph(dep_name);
                    my_pdf_report.add(para_ob);

                    //create a cell object

                    table_cell=new PdfPCell(new Phrase("No"));

                    my_report_table.addCell(table_cell);
                    table_cell=new PdfPCell(new Phrase("Name"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Sex"));
                    my_report_table.addCell(table_cell);

                    table_cell=new PdfPCell(new Phrase("Class code"));
                    my_report_table.addCell(table_cell);
                }




                int no=0;
                try{
                    String l_na = queryOutput.getString("l_name");
                    do {
                        Paragraph para_ob = new Paragraph(" \n");
                        my_pdf_report.add(para_ob);
                        no = no + 1;
                        String num = String.valueOf(no);
                        table_cell=new PdfPCell(new Phrase(num));
                        my_report_table.addCell(table_cell);

                        String name = queryOutput.getString("f_name") +" "+ queryOutput.getString("l_name");
                        table_cell=new PdfPCell(new Phrase(name));



                        my_report_table.addCell(table_cell);
                        String manager_id=queryOutput.getString("sex");
                        table_cell=new PdfPCell(new Phrase(manager_id));
                        my_report_table.addCell(table_cell);
                        String location_id=queryOutput.getString("Class_Atribute");
                        table_cell=new PdfPCell(new Phrase(location_id));
                        my_report_table.addCell(table_cell);

                        System.out.println(no);
                    } while (queryOutput.next());
                }
                catch (SQLException uu){

                }


                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);



            }

        }
        my_pdf_report.close();


        two.setText("Students per Class");
    }
    public void statisticsOfEnrolment(ActionEvent event) throws IOException, SQLException, DocumentException {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String productViewQuery = "select f_name, l_name, sex, qualification from student where stu_id > 13 and registered is true";

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(productViewQuery);
        /* Step-2: Initialize PDF documents - logical objects */
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("statisticsOfEnrolment.pdf"));
        my_pdf_report.open();

        String paragraph = "                                                                                FIRST REPORT\n         \n";
        Paragraph para_obj = new Paragraph(paragraph);
        my_pdf_report.add(para_obj);
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(4);
        //create a cell object
        PdfPCell table_cell;
        table_cell=new PdfPCell(new Phrase("f_name"));

        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("l_name"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Sex"));
        my_report_table.addCell(table_cell);

        table_cell=new PdfPCell(new Phrase("Qualification"));
        my_report_table.addCell(table_cell);
        while (queryOutput.next()) {
            String dept_id = queryOutput.getString("f_name");
            table_cell=new PdfPCell(new Phrase(dept_id));

            my_report_table.addCell(table_cell);
            String dept_name=queryOutput.getString("l_name");
            table_cell=new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id=queryOutput.getString("sex");
            table_cell=new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
            String location_id=queryOutput.getString("qualification");
            table_cell=new PdfPCell(new Phrase(location_id));
            my_report_table.addCell(table_cell);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();


        seven.setText("statistics of enrolment");

    }
    public void Back_to_admin(ActionEvent event) throws IOException{



        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminDashboard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("productsearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void open_file(String filename)  {
        System.out.println("i am in");
        try{

            Runtime.getRuntime().exec("rundll32 url.dll FileProtocolHandler " + "F://SDT//student_management_systemsss//" +filename +".pdf");
        }
        catch (Exception ee){
            ee.printStackTrace();
        }

    }
    public  void  openFile1(MouseEvent event){

                    open_file("Registered_Students");
    }

    public  void  openFile2(MouseEvent event){
        open_file("Students_per_Class");

    }
    public  void  openFile3(MouseEvent event){
        open_file("male_students_per_class");

    }
    public  void  openFile4(MouseEvent event){

        open_file("femaleStudentsPerClass");

    }
    public  void  openFile5(MouseEvent event){
        open_file("Studentpercycle");

    }
    public  void  openFile6(MouseEvent event){
        open_file("studentperdepartment");

    }
    public  void  openFile7(MouseEvent event){
        open_file("statisticsOfEnrolment");

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
