package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");

        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });

        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(viewStore);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    protected JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    protected abstract JPanel createCenter();
}