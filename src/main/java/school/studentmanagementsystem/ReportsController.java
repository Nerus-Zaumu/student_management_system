package school.studentmanagementsystem;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ReportsController {
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;


    public void Registered_Students(ActionEvent event) throws IOException, SQLException {
//        PdfPTable my_report_table = null;
//
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//
//        String productViewQuery = "select f_name, l_name, sex, qualification from student where stu_id > 13 and registered is true";
//
//        Statement statement = connectDB.createStatement();
//        ResultSet queryOutput = statement.executeQuery(productViewQuery);
//        /* Step-2: Initialize PDF documents - logical objects */
//        /* Step-2: Initialize PDF documents - logical objects */
//        Document my_pdf_report = new Document();
//        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
//        my_pdf_report.open();
//        //we have four columns in our table
//        PdfPTable my_first_table = new PdfPTable(4);
//        //create a cell object
//        PdfPCell table_cell;
//
//        while (queryOutput.next()) {
//            String dept_id = queryOutput.getString("f_name");
//            table_cell=new PdfPCell(new Phrase(dept_id));
//
//            my_report_table.addCell(table_cell);
//            String dept_name=queryOutput.getString("l_name");
//            table_cell=new PdfPCell(new Phrase(dept_name));
//            my_report_table.addCell(table_cell);
//            String manager_id=queryOutput.getString("sex");
//            table_cell=new PdfPCell(new Phrase(manager_id));
//            my_report_table.addCell(table_cell);
//            String location_id=queryOutput.getString("qualification");
//            table_cell=new PdfPCell(new Phrase(location_id));
//            my_report_table.addCell(table_cell);
//        }
//        /* Attach report table to PDF */
//        my_pdf_report.add(my_report_table);
//        my_pdf_report.close();
//
//
//        System.out.println(queryOutput);
    }
    public void Back_to_admin(ActionEvent event) throws IOException{



        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminDashboard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // FXMLLoader fxmlLoader = new FXMLLoader(studentRegistrationForm.class.getResource("productsearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
