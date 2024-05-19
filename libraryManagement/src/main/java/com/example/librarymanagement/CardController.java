package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Book;

import java.util.Objects;


public class CardController {
    @FXML
    private Label authorName;

    @FXML
    private Label bookName;

    @FXML
    private HBox box;

    @FXML
    private ImageView bookImage;

    private String[] colors = {"#B9E5FF", "#BDB2FE", "#FB9AA8", "#FF5056"};


    public void setData(Book book) {
        if (book != null && book.getImageScr() != null) {
            try {
                Image image = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(book.getImageScr())));
                bookImage.setImage(image);
            } catch (NullPointerException e) {
                System.err.println("Error loading image: " + e.getMessage());
            }

            if (book.getName() != null) {
                bookName.setText(book.getName());
            } else {
                bookName.setText("Unknown");
            }

            if (book.getAuthor() != null) {
                authorName.setText(book.getAuthor());
            } else {
                authorName.setText("Unknown");
            }

            box.setStyle("-fx-background-color: " + Color.web(colors[(int) (Math.random() * colors.length)]));
        } else {
            System.out.println("Invalid book data provided.");
        }
    }
}