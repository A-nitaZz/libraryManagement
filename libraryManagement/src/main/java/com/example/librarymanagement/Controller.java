package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox cardLayout;

    private List<Book> recentlyAdded;

    @FXML
    private TextField searchTextField;

    @FXML
    private ImageView searchImageView;

    @FXML
    private void handleSearchClick(MouseEvent event) {
        String searchText = searchTextField.getText();
        if (searchText != null && !searchText.isEmpty()) {
            System.out.println("Searching for: " + searchText);
        } else {
            System.out.println("Search field is empty");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        try {
            for (Book book : recentlyAdded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/librarymanagement/hello-view.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(book);
                cardLayout.getChildren().add(cardBox);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Book> recentlyAdded() {
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Funny \n Story");
        book.setImageScr("FS.png"); // Image name only
        book.setAuthor("Emily Henry");
        ls.add(book);

        book = new Book();
        book.setName("The ABC Murders: \n A Hercule Poirot Mystery");
        book.setImageScr("HTEALS.jpg"); // Image name only
        book.setAuthor("Agatha Christie");
        ls.add(book);

        book = new Book();
        book.setName("How to End a Love Story: \n A Novel");
        book.setImageScr("NIL.jpg"); // Image name only
        book.setAuthor("Yulin Kuang");
        ls.add(book);

        return ls;
    }
}
