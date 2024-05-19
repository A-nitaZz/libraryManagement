package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Book;
import javafx.scene.image.Image;

public class BookController {

    @FXML
    private Label authorName;

    @FXML
    private ImageView bookImage;

    @FXML
    private Label bookName;

    public void setData(Book book) {
        if (book != null && book.getImageSrc() != null) {
            try {
                String imagePath = book.getImageSrc();
                System.out.println("Loading image from path: " + imagePath); // Debug statement

                var resourceStream = getClass().getClassLoader().getResourceAsStream(imagePath);
                if (resourceStream == null) {
                    System.out.println("Resource not found: " + imagePath);
                } else {
                    Image image = new Image(resourceStream);
                    bookImage.setImage(image);
                }

                bookName.setText(book.getName());
                authorName.setText(book.getAuthor());
            } catch (Exception e) {
                System.out.println("Error setting data for book: " + book.getName());
                e.printStackTrace();
            }
        } else {
            System.out.println("Book or book image source is null");
        }
    }
}