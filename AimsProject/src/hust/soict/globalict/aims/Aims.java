package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
public class Aims {

	public static void main(String[] args) {

	    // Create a new cart
	    Cart anOrder = new Cart();

	    // Create new dvd objects and add them to the cart
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
	            "Animation", "Roger Allers", 87, 19.95f);
	    anOrder.addDigitalVideoDisc(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
	            "Science Fiction", "George Lucas", 87, 24.95f);
	    anOrder.addDigitalVideoDisc(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
	            "Animation", 18.99f);
	    anOrder.addDigitalVideoDisc(dvd3);

	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception",
	            "Sci-Fi", "Christopher Nolan", 148, 29.99f);

	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight",
	            "Action", "Christopher Nolan", 152, 27.50f);

	    DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers: Endgame",
	            "Superhero", "Anthony Russo", 181, 34.99f);

	    DigitalVideoDisc dvd7 = new DigitalVideoDisc("Frozen",
	            "Animation", "Chris Buck", 102, 22.99f);

	    DigitalVideoDisc dvd8 = new DigitalVideoDisc("Titanic",
	            "Romance", "James Cameron", 195, 21.00f);
	    // print total cost of the items in the cart
	    //System.out.println("Total Cost is: ");
	    //System.out.println(anOrder.totalCost());
	    anOrder.printCart();
	    
	    anOrder.removeDigitalVideoDisc(dvd3);	    
	    anOrder.printCart();
	    

	    anOrder.addDigitalVideoDisc(dvd4);	    
	    anOrder.printCart();
	    
	    anOrder.removeDigitalVideoDisc(dvd1);
	    anOrder.removeDigitalVideoDisc(dvd2);
	    anOrder.removeDigitalVideoDisc(dvd3);
	    anOrder.removeDigitalVideoDisc(dvd4);
	    anOrder.removeDigitalVideoDisc(dvd1);
	    
	    anOrder.printCart();
	}

}
