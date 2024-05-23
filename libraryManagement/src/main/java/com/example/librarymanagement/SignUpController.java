package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField address;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField eMail;

    @FXML
    private TextField firstName;

    @FXML
    private ChoiceBox<String> genderBox;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private TextField phoneNumber;

    private final String[] genderOptions = {"Male", "Female"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // You can add additional initialization here if needed
        genderBox.getItems().addAll(genderOptions);
        genderBox.setValue(genderOptions[0]);
        signUpBtn.setOnAction(event -> signUp());
    }

    private void signUp() {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        String genderText = genderBox.getValue(); // Assuming the genderChoiceBox is already populated
        LocalDate birthDateValue = birthDate.getValue(); // Assuming birthDate is a DatePicker
        String phoneNumberText = phoneNumber.getText();
        String emailText = eMail.getText();
        String addressText = address.getText();
        String passwordText = password.getText();
        String confirmPasswordText = confirmPassword.getText();

        boolean isValid = validateInput(firstNameText, lastNameText, genderText, birthDateValue, phoneNumberText, emailText, addressText, passwordText, confirmPasswordText);

        if (isValid) {
            switchToBookstoreScene();
        } else {
            showAlert("Please fill out all required fields and ensure passwords match.");
        }

    }

    private boolean validateInput(String firstNameText, String lastNameText, String genderText, LocalDate birthDateValue, String phoneNumberText, String emailText, String addressText, String passwordText, String confirmPasswordText) {
        if (firstNameText.isEmpty() ||
                lastNameText.isEmpty() ||
                genderText.isEmpty() ||
                birthDateValue == null ||
                phoneNumberText.isEmpty() ||
                emailText.isEmpty() ||
                addressText.isEmpty() ||
                passwordText.isEmpty() ||
                confirmPasswordText.isEmpty()) {

            showAlert("Please fill in all fields.");
            return false;
        }

        if (!passwordText.equals(confirmPasswordText)) {
            showAlert("Passwords do not match.");
            return false;
        }

        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void switchToBookstoreScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/librarymanagement/BookStore.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) signUpBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.sizeToScene();
            stage.show();
        } catch (IOException e) {
            showAlert("Error switching to the next scene.");
            e.printStackTrace();
        }
    }
}