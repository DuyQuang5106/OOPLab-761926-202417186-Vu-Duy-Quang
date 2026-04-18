package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		
		// Test the print method
		cart.printCart();
		
		// Test the search methods
		System.out.println("Search by ID: 2");
		cart.searchById(2);
		
		System.out.println("\nSearch by Title: 'Alad'");
		cart.searchByTitle("Alad");
		
		System.out.println("\nSearch by Title: 'Frozen'");
		cart.searchByTitle("Frozen");
	}
}
