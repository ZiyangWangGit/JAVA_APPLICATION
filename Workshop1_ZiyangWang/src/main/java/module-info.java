module com.example.workshop1_ziyangwang {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop1_ziyangwang to javafx.fxml;
    exports com.example.workshop1_ziyangwang;
}