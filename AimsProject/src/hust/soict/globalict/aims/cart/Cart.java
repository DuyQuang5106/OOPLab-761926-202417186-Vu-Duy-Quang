package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public int nbDVD = 0;
	public void addMedia(Media m)
	{
			if(itemsOrdered.contains(m))
			{
				System.out.println("addMedia: Error! This media is already in the cart!");
				return;
			}
		itemsOrdered.add(m);
		System.out.println("addMedia: Successfully added media to the cart");
	}
	public void removeMedia(Media m)
	{
		if(itemsOrdered.contains(m))
		{
				itemsOrdered.remove(m);
				System.out.println("removeMedia: Successfully removed media: ");
				return;
		}
		System.out.println("removeMedia: Error! Media was not found in the cart");
	}
	public float totalCost()
	{
		float sum = 0;
		for(int i = 0; i < itemsOrdered.size(); i++)
		{
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void printCart()
	{
		System.out.println("\n***********************CART***********************");
		if(itemsOrdered.size() == 0)
		{
			System.out.println("The cart is empty!");
			System.out.println("***************************************************\n");
			return;
		}
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); i++)
		{
			System.out.println((i+1) + ". " + itemsOrdered.get(i));
		}
		
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************\n");
	}
	// Tìm kiếm theo Title (Trả về đối tượng Media đầu tiên tìm thấy)
	public Media findByTitle(String title) {
	    for (Media media : itemsOrdered) { // itemsOrdered là ArrayList<Media> của bạn
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            return media;
	        }
	    }
	    return null;
	}


	public void searchById(int id) {
	    boolean found = false;
	    for (Media media : itemsOrdered) {
	        if (media.getId() == id) {
	            System.out.println("Found Media: " + media.toString());
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No media found with ID: " + id);
	    }
	}


	public void searchByTitle(String title) {
	    boolean found = false;
	    for (Media media : itemsOrdered) {
	        if (media instanceof hust.soict.globalict.aims.media.DigitalVideoDisc) {
	            if (((hust.soict.globalict.aims.media.DigitalVideoDisc)media).isMatch(title)) {
	                System.out.println("Found DVD: " + media.toString());
	                found = true;
	            }
	        } else if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found Media: " + media.toString());
                found = true;
            }
	    }
	    if (!found) {
	        System.out.println("No media found with title containing: " + title);
	    }
	}
	
	public void sortByTitle()
	{
		java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		System.out.println("Cart sorted by Title.");
	}
	public void sortByCost()
	{
		java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
		System.out.println("Cart sorted by Cost.");
	}
	public void clearCart() {
	    itemsOrdered.clear();
	    nbDVD = 0; // Reset your DVD counter too
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
