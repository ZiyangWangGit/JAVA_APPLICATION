module com.example.workshop2_ziyangwang {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop2_ziyangwang to javafx.fxml;
    exports com.example.workshop2_ziyangwang;
}