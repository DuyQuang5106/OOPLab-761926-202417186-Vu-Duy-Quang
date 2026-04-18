package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title)
	{
		super(title, null, 0.0f, 0, null);
	}
	public DigitalVideoDisc(String title, String category, float cost)
	{
		super(title, category, cost, 0, null);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost)
	{
		super(title, category, cost, 0, director);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost)
	{
		super(title, category, cost, length, director);
	}
	
	@Override
	public void play()
	{
		if(super.getLength() < 0)
		{
			System.out.println("Playing DVD: " + this.getTitle()); 
			System.out.println("DVD length: " + this.getLength());
		}
		else
		{
			System.out.println("ERROR: Cannot play DVD \"" + title + "\" (length = 0)");
		}
	}
	
    @Override
    public String toString() {
        return "DVD - [" + getId() + "] " + getTitle() 
               + " - " + getCategory() 
               + " - " + getDirector() 
               + " - " + getLength() + " mins - " + getCost() + "$";
    }
}
