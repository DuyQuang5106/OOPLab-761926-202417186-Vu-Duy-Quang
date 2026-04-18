package hust.soict.globalict.aims.media;

public abstract class Disc extends Media{
	private int length;
	private String director;
	
	public Disc(String title, String category, float cost, int length, String director)
	{
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public String getDirector()
	{
		return director;
	}
	@Override
	public void mediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
		} 
}
