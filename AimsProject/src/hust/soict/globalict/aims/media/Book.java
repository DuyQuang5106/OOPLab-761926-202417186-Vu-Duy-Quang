package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	public static int nbBooks = 0;
	public Book(String title, String category, float cost, ArrayList<String> authors) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
		this.authors = new ArrayList<> (authors);
	}
	public List<String> getAuthors() {
		return new ArrayList<>(authors);
	}
	
	public void addAuthor(String authorName)
	{
		for(int i = 0; i < authors.size(); i++)
		{
			if(authorName.equals(authors.get(i)))
			{
				System.out.println("addAuthor: error! This author is already added");
				return;
			}
		}
		authors.add(authorName);
		System.out.println("addAuthor: Successfully added author: " + authorName);
		return;
	}
	
	public void removeAuthor(String authorName)
	{
		for(int i = 0; i < authors.size(); i++)
		{
			if(authorName.equals(authors.get(i)))
			{
				authors.remove(i);
				System.out.println("removeAuthor: Successfully deleted author: " + authorName);
				return;
			}
		}
		System.out.println("removeAuthor: error! Author " + authorName+ "Not found!");
		return;
	}
	
    @Override
    public String toString() {
        return "Book - [" + getId() + "] " + getTitle() 
               + " - " + getCategory() 
               + " - Authors: " + authors 
               + " - " + getCost() + "$";
    }
    
    @Override
    public void mediaDetailsMenu() { 
    	System.out.println("Options: "); 
    	System.out.println("--------------------------------"); 
    	System.out.println("1. Add to cart");  
    	System.out.println("0. Back"); 
    	System.out.println("--------------------------------"); 
    	System.out.println("Please choose a number: 0-1-2"); 
    	} 
}
