package hust.soict.globalict.aims.screen.manager;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
		
	public StoreManagerScreen(Store store)
	{
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	JPanel createNorth()
	{
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
		
	}
	
	JMenuBar createMenuBar()
	{
		JMenu menu = new JMenu("Options");
		
		menu.add(new JMenuItem("View store"));
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
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
		menu.add(smUpdateStore);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader()
	{
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
	
	JPanel createCenter()
	{
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		
		for(int i = 0; i < mediaInStore.size(); i++)
		{
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public static void main(String[] args) {
	    Store store = new Store();

	    // DVDs
	    store.addMedia(new DigitalVideoDisc(
	            "American Psycho",
	            "Psychological Thriller",
	            "Mary Harron",
	            102,
	            19.99f));

	    store.addMedia(new DigitalVideoDisc(
	            "Fight Club",
	            "Psychological Drama",
	            "David Fincher",
	            139,
	            24.99f));

	    store.addMedia(new DigitalVideoDisc(
	            "Se7en",
	            "Crime Thriller",
	            "David Fincher",
	            127,
	            22.50f));

	    store.addMedia(new DigitalVideoDisc(
	            "Zodiac",
	            "Mystery Thriller",
	            "David Fincher",
	            157,
	            25.00f));

	    store.addMedia(new DigitalVideoDisc(
	            "Prisoners",
	            "Crime Thriller",
	            "Denis Villeneuve",
	            153,
	            23.99f));

	    store.addMedia(new DigitalVideoDisc(
	            "Gone Girl",
	            "Psychological Thriller",
	            "David Fincher",
	            149,
	            21.99f));

	    store.addMedia(new DigitalVideoDisc(
	            "Nightcrawler",
	            "Neo-Noir Thriller",
	            "Dan Gilroy",
	            117,
	            20.99f));

	    store.addMedia(new DigitalVideoDisc(
	            "Shutter Island",
	            "Psychological Mystery",
	            "Martin Scorsese",
	            138,
	            24.50f));

	    // CDs
	    store.addMedia(new CompactDisc(
	            "Fight Club Soundtrack",
	            "Soundtrack",
	            "David Fincher",
	            60,
	            14.99f,
	            "Dust Brothers"));

	    store.addMedia(new CompactDisc(
	            "American Psycho Soundtrack",
	            "Soundtrack",
	            "Mary Harron",
	            55,
	            13.99f,
	            "Various Artists"));

	    store.addMedia(new CompactDisc(
	            "Se7en Soundtrack",
	            "Soundtrack",
	            "David Fincher",
	            58,
	            15.50f,
	            "Howard Shore"));

	    store.addMedia(new CompactDisc(
	            "Gone Girl Soundtrack",
	            "Ambient",
	            "David Fincher",
	            65,
	            16.99f,
	            "Trent Reznor"));

	    store.addMedia(new CompactDisc(
	            "Shutter Island Soundtrack",
	            "Classical",
	            "Martin Scorsese",
	            62,
	            14.50f,
	            "Various Artists"));

	    store.addMedia(new CompactDisc(
	            "Zodiac Soundtrack",
	            "Soundtrack",
	            "David Fincher",
	            57,
	            13.50f,
	            "David Shire"));

	    // Books
	    store.addMedia(new Book(
	            "American Psycho",
	            "Psychological Horror",
	            18.99f,
	            new ArrayList<String>() {{
	                add("Bret Easton Ellis");
	            }}));

	    store.addMedia(new Book(
	            "Fight Club",
	            "Psychological Fiction",
	            16.99f,
	            new ArrayList<String>() {{
	                add("Chuck Palahniuk");
	            }}));

	    store.addMedia(new Book(
	            "Gone Girl",
	            "Mystery Thriller",
	            17.50f,
	            new ArrayList<String>() {{
	                add("Gillian Flynn");
	            }}));

	    store.addMedia(new Book(
	            "The Silence of the Lambs",
	            "Crime Horror",
	            19.50f,
	            new ArrayList<String>() {{
	                add("Thomas Harris");
	            }}));

	    store.addMedia(new Book(
	            "The Girl with the Dragon Tattoo",
	            "Crime Thriller",
	            18.50f,
	            new ArrayList<String>() {{
	                add("Stieg Larsson");
	            }}));

	    store.addMedia(new Book(
	            "No Country for Old Men",
	            "Crime Fiction",
	            15.99f,
	            new ArrayList<String>() {{
	                add("Cormac McCarthy");
	            }}));

	    // Launch GUI
	    new StoreManagerScreen(store);
	}
}
