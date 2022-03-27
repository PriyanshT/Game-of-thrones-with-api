module com.example.assignment02gc200472583 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.assignment02gc200472583 to javafx.fxml, com.google.gson;
    exports com.example.assignment02gc200472583;
}