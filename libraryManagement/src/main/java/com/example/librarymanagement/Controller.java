package com.example.librarymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        try {
            for (int i=0; i<recentlyAdded.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(recentlyAdded.get(i));
                cardLayout.getChildren().add(cardBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
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