package hust.soict.globalict.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD To Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7, 2, 10, 10));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();
        tfArtist = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        center.add(tfLength);

        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        center.add(new JLabel("Artist:"));
        center.add(tfArtist);

        JButton addButton = new JButton("Add CD");

        addButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(
                    title,
                    category,
                    director,
                    length,
                    cost,
                    artist
            );

            store.addMedia(cd);

            dispose();
            new StoreManagerScreen(store);
        });

        center.add(new JLabel(""));
        center.add(addButton);

        return center;
    }
}