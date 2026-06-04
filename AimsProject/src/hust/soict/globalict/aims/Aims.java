package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aims {
	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
		} 
		public static void storeMenu() { 
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. See a media’s details"); 
			System.out.println("2. Add a media to cart"); 
			System.out.println("3. Play a media"); 
			System.out.println("4. See current cart"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4"); 
		}
		public static void mediaDetailsMenu() { 
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Add to cart"); 
			System.out.println("2. Play"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2"); 
			} 
		public static void cartMenu() { 
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Filter media in cart"); 
			System.out.println("2. Sort media in cart"); 
			System.out.println("3. Remove media from cart"); 
			System.out.println("4. Play a media"); 
			System.out.println("5. Place order"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4-5"); 
			}
		
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	showMenu();
        	int i = Integer.parseInt(sc.nextLine());
        	if(i == 0) {
        		System.out.println("Bye!");
        		break;
        	} else if (i == 1) { // 1 View store
        		while(true) {
        			store.printStore();
        			storeMenu();
            		int i1 = Integer.parseInt(sc.nextLine());
            		if(i1 == 1) { // 1.1 See a media's details 
            			System.out.println("Enter media title:");
            			String s = sc.nextLine();
            			Media m = store.findByTitle(s);
            			if(m == null) {
            				System.out.println("Media not found!");
            			} else {
            				System.out.println(m.toString());
            				mediaDetailsMenu();
            				int detailOption = Integer.parseInt(sc.nextLine());
            				if(detailOption == 1) {
            					cart.addMedia(m);
            					if (m instanceof DigitalVideoDisc) cart.nbDVD++;
            					System.out.println("Current number of DVDs in cart: " + cart.nbDVD);
            				} else if (detailOption == 2) {
            					if(m instanceof Playable) {
            						try {
            							((Playable)m).play();
            						} catch (PlayerException exception) {
            							System.out.println(exception.getMessage());
            						}
            					} else {
            						System.out.println("Sorry, can't play a book");
            					}
            				}
            			}
            		} else if(i1 == 2) { // 1.2 Add media to cart
            			System.out.println("Please enter the title of the media you want to add to cart:");
            			String title = sc.nextLine();
            			Media m = store.findByTitle(title);
            			if (m == null) {
            			    System.out.println("Sorry, that title was not found in the store.");
            			} else {
            			    cart.addMedia(m); 
            			    if (m instanceof DigitalVideoDisc) {
            			        cart.nbDVD++;
            			    }
            			    System.out.println("Current number of DVDs in cart: " + cart.nbDVD);
            			}
            		} else if(i1 == 3) { // 1.3 Play a media
            			System.out.println("Please enter the title of the media you want to play: ");
            			String title = sc.nextLine();
            			Media m = store.findByTitle(title);
            			if(m == null) {
            				System.out.println("Sorry, that title was not found in the store.");
            			} else {
            				if(m instanceof Playable) {
            					try {
            						((Playable)m).play();
            					} catch (PlayerException exception) {
            						System.out.println(exception.getMessage());
            					}
            				} else {
            					System.out.println("Sorry, can't play this media");
            				}
            			}
            		} else if(i1 == 4) { // 1.4 See current cart
            			cart.printCart();
            		} else if(i1 == 0) { // 1.0 Back
            			break;
            		} else { // Wrong input
            			System.out.println("Wrong input. Please choose a number: 0-1-2-3-4"); 
            		}
        		}
        	} else if (i == 2) { // 2 Update store
        		System.out.println("Update Store Options: ");
        	    System.out.println("--------------------------------");
        	    System.out.println("1. Add a media to the store");
        	    System.out.println("2. Remove a media from the store");
        	    System.out.println("0. Back to main menu");
        	    System.out.println("--------------------------------");
        	    System.out.print("Please choose an option: ");
        	    
        	    int updateOption = Integer.parseInt(sc.nextLine());

        	    if (updateOption == 1) {
        	        System.out.println("Enter the type of media (book, DVD, CD): ");
        	        String type = sc.nextLine();
        	        System.out.println("Enter title: ");
        	        String title = sc.nextLine();
        	        System.out.println("Enter category: ");
        	        String category = sc.nextLine();
        	        System.out.println("Enter cost: ");
        	        float cost = Float.parseFloat(sc.nextLine());

        	        if (type.equalsIgnoreCase("book")) {
        	            System.out.println("Enter authors (comma separated): ");
        	            String authorStr = sc.nextLine();
        	            ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorStr.split("\\s*,\\s*")));
        	            store.addMedia(new Book(title, category, cost, authors));
        	        } else if (type.equalsIgnoreCase("DVD")) {
        	            System.out.println("Enter director: ");
        	            String director = sc.nextLine();
        	            System.out.println("Enter length: ");
        	            int length = Integer.parseInt(sc.nextLine());
        	            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        	        } else if (type.equalsIgnoreCase("CD")) {
        	            System.out.println("Enter director: ");
        	            String director = sc.nextLine();
        	            System.out.println("Enter artist: ");
        	            String artist = sc.nextLine();
        	            System.out.println("Enter length: ");
        	            int length = Integer.parseInt(sc.nextLine());
        	            store.addMedia(new CompactDisc(title, category, director, length, cost, artist));
        	        }
        	        System.out.println("Item added to store.");

        	    } else if (updateOption == 2) {
        	        System.out.println("Enter the title of the media to remove: ");
        	        String titleToRemove = sc.nextLine();
        	        Media m = store.findByTitle(titleToRemove);
        	        if (m != null) {
        	            store.removeMedia(m);
        	            System.out.println("Item removed successfully.");
        	        } else {
        	            System.out.println("Media not found in store.");
        	        }
        	    }
        	} else if (i == 3) { // 3. See current cart
        	    cart.printCart(); 
        	    while (true) {
        	        cartMenu();
        	        int cartOption = Integer.parseInt(sc.nextLine());
        	        if (cartOption == 0) { // Back
        	            break; 
        	        } else if (cartOption == 1) { // 3.1 Filter media
        	            System.out.println("Filter by: 1. ID  2. Title");
        	            int filterChoice = Integer.parseInt(sc.nextLine());
        	            if (filterChoice == 1) {
        	                System.out.print("Enter ID: ");
        	                int id = Integer.parseInt(sc.nextLine());
        	                cart.searchById(id);
        	            } else {
        	                System.out.print("Enter Title: ");
        	                String filterTitle = sc.nextLine();
        	                cart.searchByTitle(filterTitle);
        	            }
        	        } else if (cartOption == 2) { // 3.2 Sort media
        	            System.out.println("Sort by: 1. Title  2. Cost");
        	            int sortChoice = Integer.parseInt(sc.nextLine());
        	            if (sortChoice == 1) {
        	                cart.sortByTitle();
        	            } else {
        	                cart.sortByCost();
        	            }
        	            cart.printCart();
        	        } else if (cartOption == 3) { // 3.3 Remove media
        	            System.out.print("Enter title to remove: ");
        	            String removeTitle = sc.nextLine();
        	            Media m = cart.findByTitle(removeTitle); 
        	            if (m != null) {
        	                cart.removeMedia(m);
        	                if (m instanceof DigitalVideoDisc) cart.nbDVD--;
        	                System.out.println("Removed " + removeTitle);
        	            } else {
        	                System.out.println("Media not found in cart.");
        	            }
        	        } else if (cartOption == 4) { // 3.4 Play media
        	            System.out.print("Enter title to play: ");
        	            String playTitle = sc.nextLine();
        	            Media m = cart.findByTitle(playTitle);
        	            if (m instanceof Playable) {
        	                try {
        	                	((Playable) m).play();
        	                } catch (PlayerException exception) {
        	                	System.out.println(exception.getMessage());
        	                }
        	            } else {
        	                System.out.println("This item cannot be played.");
        	            }
        	        } else if (cartOption == 5) { // 3.5 Place order
        	            System.out.println("Order has been placed! Your cart is now empty.");
        	            cart.clearCart(); 
        	            break; 
        	        }
        	    }
        	} else { // False input
        		System.out.println("Please choose options 1, 2 or 3, or press 0 to exit");
        	}
        }
        sc.close();
     }
 }
