package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox cardLayout;

    @FXML
    private GridPane bookContainer;

    private List<Book> recentlyAdded;
    private List<Book> browsedBooks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        browsedBooks = new ArrayList<>(books());
        int column = 0;
        int row = 1;
        try {
            for (Book value : recentlyAdded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/librarymanagement/card.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(value);
                cardLayout.getChildren().add(cardBox);
            }
            for (Book book : browsedBooks) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/librarymanagement/book.fxml"));
                VBox bookBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);
                if (column == 6) {
                    column = 0;
                    row++;
                }
                bookContainer.add(bookBox, column++, row);
                GridPane.setMargin(bookBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Book> recentlyAdded() {
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Funny \nStory");
        book.setImageSrc("src/main/resources/image/FS.png");
        book.setAuthor("Emily Henry");
        ls.add(book);

        book = new Book();
        book.setName("The ABC Murders: \nA Hercule Poirot Mystery");
        book.setImageSrc("src/main/resources/image/FS.png");
        book.setAuthor("Agatha Christie");
        ls.add(book);

        book = new Book();
        book.setName("How to End a Love Story: \nA Novel");
        book.setImageSrc("com/example/librarymanagement/imgs/NIL.jpg");
        book.setAuthor("Yulin Kuang");
        ls.add(book);

        return ls;
    }

    private List<Book> books() {
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Funny Story");
        book.setImageSrc("src/main/resources/image/FS.png");
        book.setAuthor("Emily Henry");
        ls.add(book);

        book = new Book();
        book.setName("The ABC Murders:A Hercule Poirot Mystery");
        book.setImageSrc("src/main/resources/image/FS.png");
        book.setAuthor("Agatha Christie");
        ls.add(book);

        book = new Book();
        book.setName("How to End a Love Story: A Novel");
        book.setImageSrc("src/main/resources/image/FS.png");
        book.setAuthor("Yulin Kuang");
        ls.add(book);

        return ls;
    }
}