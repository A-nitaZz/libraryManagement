module com.example.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.librarymanagement to javafx.fxml;
    exports com.example.librarymanagement;
    exports model; // Ensure this line exports the model package
}