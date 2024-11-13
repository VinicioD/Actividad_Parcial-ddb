module com.example.guiltyspark {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.guiltyspark to javafx.fxml;
    exports com.example.guiltyspark;
    exports com.example.guiltyspark.controller;
    opens com.example.guiltyspark.controller to javafx.fxml;
}