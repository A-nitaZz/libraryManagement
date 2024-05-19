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

    private final String[] colors = {"#B9E5FF", "#BDB2FE", "#FB9AA8", "#FF5056"};


    public void setData(Book book) {
        Objects.requireNonNull(book.getImageScr(), "Book image source must not be null");

        // Debug prints to verify paths
        System.out.println("Loading image: /image/" + book.getImageScr());

        // Correct path for resources
        String imagePath = "/image/" + book.getImageScr();
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath), "Image resource not found: " + imagePath));
        bookImage.setImage(image);

        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());
        box.setStyle("-fx-background-color: " + Color.web(colors[(int)(Math.random() * colors.length)]));
    }
}