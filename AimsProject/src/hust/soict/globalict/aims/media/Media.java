package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private static int nextId = 0;
	int id;
	String title;
	String category;
	float cost;
	
	
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public Media(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.id = ++nextId;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if (obj == null || !(obj instanceof Media)) return false;
		
		Media other = (Media) obj;
		return title != null && title.equals(other.title);
	}
	
	@Override
	public String toString()
	{
		return "Media - [" + id + "] " + title + " - " + category + " - " + cost  + "$"; 
	}
	
}
