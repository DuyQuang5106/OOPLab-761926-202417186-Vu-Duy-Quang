package hust.soict.globalict.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	public static int nbDiscs = 0;
	
	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}


	public Disc(int id, String title, String category, float cost, int length, String director) {
		// TODO Auto-generated constructor stub
		super(++nbDiscs, title, category, cost);
		this.length = length;
		this.director = director;
	}

}
