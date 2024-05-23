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
        if (book != null && book.getImageSrc() != null) {
            try {
                String imagePath = book.getImageSrc();
                System.out.println("Loading image from path: " + imagePath); // Debug statement

                var resourceStream = getClass().getResourceAsStream(imagePath);
                if (resourceStream == null) {
                    System.out.println("Resource not found: " + imagePath);
                } else {
                    Image image = new Image(resourceStream);
                    bookImage.setImage(image);
                }

                bookName.setText(book.getName());
                authorName.setText(book.getAuthor());

                // Set the random background color
                String color = colors[(int) (Math.random() * colors.length)];
                System.out.println("Setting HBox color to: " + color); // Debug statement
                box.setStyle("-fx-background-color: " + color +
                        "; -fx-background-radius: 15;" +
                        "; -fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0);"); // Added background radius

            } catch (Exception e) {
                System.out.println("Error setting data for book: " + book.getName());
                e.printStackTrace();
            }
        } else {
            System.out.println("Book or book image source is null");
        }
    }
}