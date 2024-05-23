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
                if (column == 5) {
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
        book.setImageSrc("/image/FS.png");
        book.setAuthor("Emily Henry");
        ls.add(book);

        book = new Book();
        book.setName("The ABC Murders: \nA Hercule Poirot Mystery");
        book.setImageSrc("/image/TABCM.jpg");
        book.setAuthor("Agatha Christie");
        ls.add(book);

        book = new Book();
        book.setName("How to End a Love Story: \nA Novel");
        book.setImageSrc("/image/HTEALS.jpg");
        book.setAuthor("Yulin Kuang");
        ls.add(book);

        return ls;
    }

    private List<Book> books() {
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setName("Sensitive: \nThe Hidden Power of the Highly Sensitive Person in a Loud, Fast, Too-Much World");
        book.setImageSrc("/image/Sensitive.jpg");
        book.setAuthor("Jenn Granneman, Andre Sólo");
        ls.add(book);

        book = new Book();
        book.setName("Think Ahead: \n7 Decisions You Can Make Today for the God-Honoring Life You Want Tomorrow");
        book.setImageSrc("/image/Think-Ahead.jpg");
        book.setAuthor("Cherry Qut");
        ls.add(book);

        book = new Book();
        book.setName("The Ravens: \nHow to Prepare for and Profit from the Turbulent Times Ahead");
        book.setImageSrc("/image/Ravens.jpg");
        book.setAuthor("Robert Kiyosaki");
        ls.add(book);

        book = new Book();
        book.setName("Think Ahead:\n7 Decisions You Can Make Today for the God-Honoring Life You Want Tomorrow ");
        book.setImageSrc("/image/Think-Ahead.jpg");
        book.setAuthor("Cherry Qut");
        ls.add(book);

        book = new Book();
        book.setName("Mind Magic:\nThe Neuroscience of Manifestation and How It Changes Everything");
        book.setImageSrc("/image/MindMagic.jpg");
        book.setAuthor("James R. Doty, MD");
        ls.add(book);

        book = new Book();
        book.setName("Think Ahead: \n7 Decisions You Can Make Today for the God-Honoring Life You Want Tomorrow ");
        book.setImageSrc("/image/Think-Ahead.jpg");
        book.setAuthor("Cherry Qut");
        ls.add(book);

        book = new Book();
        book.setName("AI 2041:\nTen Visions for Our Future");
        book.setImageSrc("/image/AI_2024.jpg");
        book.setAuthor("Kai-Fu Lee, Chen Qiufan");
        ls.add(book);

        book = new Book();
        book.setName("Mushoku Tensei: Jobless Reincarnation\n(Light Novel) Vol. 26");
        book.setImageSrc("/image/Jobless.jpg");
        book.setAuthor("Rifujin Na Magonote");
        ls.add(book);

        book = new Book();
        book.setName("The Eminence in Shadow\nVol. 1 (light novel)");
        book.setImageSrc("/image/Shadow.jpg");
        book.setAuthor("Daisuke Aizawa");
        ls.add(book);

        book = new Book();
        book.setName("Re:Zero:\nStarting Life in Another World, Vol. 1");
        book.setImageSrc("/image/ReZero.jpg");
        book.setAuthor("Tappei Nagatsuki ");
        ls.add(book);

        book = new Book();
        book.setName("Classroom of the Elite\n(Light Novel) Vol. 1");
        book.setImageSrc("/image/Classroom.jpg");
        book.setAuthor("Syougo Kinugasa");
        ls.add(book);

        book = new Book();
        book.setName("The Kept Man of the Princess Knight\n(light novel) Vol. 1");
        book.setImageSrc("/image/TKMPK.jpg");
        book.setAuthor("Toru Shirogane");
        ls.add(book);

        book = new Book();
        book.setName("Love & Luck");
        book.setImageSrc("/image/LoveLuck.jpg");
        book.setAuthor("Jenna Evans Welch");
        ls.add(book);

        return ls;
    }
}