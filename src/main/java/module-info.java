module school.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens school.studentmanagementsystem to javafx.fxml;
    exports school.studentmanagementsystem;
}