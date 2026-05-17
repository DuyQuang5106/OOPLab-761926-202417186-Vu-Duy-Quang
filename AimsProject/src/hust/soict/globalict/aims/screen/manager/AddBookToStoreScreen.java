package hust.soict.globalict.aims.screen.manager;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book To Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 10, 10));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        center.add(new JLabel("Authors, separated by comma:"));
        center.add(tfAuthors);

        JButton addButton = new JButton("Add Book");

        addButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            ArrayList<String> authors = new ArrayList<>();
            String[] authorNames = tfAuthors.getText().split(",");

            for (String author : authorNames) {
                authors.add(author.trim());
            }

            Book book = new Book(title, category, cost, authors);

            store.addMedia(book);

            dispose();
            new StoreManagerScreen(store);
        });

        center.add(new JLabel(""));
        center.add(addButton);

        return center;
    }
}