package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Media{
	private static int nbDigitalVideoDiscs = 0;
	private int length;
	private String director;
	
	public DigitalVideoDisc(String title) {
		
		super(++nbDigitalVideoDiscs, title, null, 0);
		id = ++nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
		this.director = director;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
}
