package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	
	public String getTitle() {
		return title;
	}


	public int getLength() {
		return length;
	}


	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	@Override
	public void play()
	{
		if(length < 0)
		{
			System.out.println("Playing Track: " + this.getTitle()); 
			System.out.println("Track length: " + this.getLength());
		}
		else
		{
			System.out.println("ERROR: Cannot play track \"" + title + "\" (length = 0)");
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Track)) return false;
		
		Track other = (Track) obj;
		return title != null && title.equals(other.title)
				&& length == other.length;
	}
	
    @Override
    public String toString() {
        return "Track: " + title + " - " + length + " mins";
    }
	
}
