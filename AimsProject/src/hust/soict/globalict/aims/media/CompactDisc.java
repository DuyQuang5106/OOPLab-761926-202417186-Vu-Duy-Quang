package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>(); 
	
	public CompactDisc(String title, String artist)
	{
		super(title, null, 0.0f, 0, null);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, float cost, String artist)
	{
		super(title, category, cost, 0, null);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String director, float cost, String artist)
	{
		super(title, category, cost, 0, director);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String director, int length, float cost, String artist)
	{
		super(title, category, cost, length, director);
		this.artist = artist;
	}
	
	public String getArtist()
	{
		return artist;
	}
	public List<Track> getTracks()
	{
		return new ArrayList<>(tracks);
	}
	public void addTrack(Track k)
	{
		for(int i = 0; i < tracks.size(); i++)
		{
			if(k.getTitle().equals(tracks.get(i).getTitle()))
			{
				System.out.println("addTrack: error! track already exists");
				return;
			}
		}
		tracks.add(k);
		System.out.println("addTrack: added track successfully: [" + k.getTitle() + "] : " + k.getLength());
	}
	public void removeTrack(Track k)
	{
		for(int i = 0; i < tracks.size(); i++)
		{
			if(k.getTitle().equals(tracks.get(i).getTitle()))
			{
				tracks.remove(i);
				System.out.println("removeTrack: track ["+ k.getTitle() + "] : " + k.getLength() + " removed successfully");
				return;
			}
		}
		
		System.out.println("removeTrack: track ["+ k.getTitle() + "] : " + k.getLength() + " not found in CD");
	}
	public int getLength()
	{
		int length = 0;
		for(int i = 0; i < tracks.size(); i++)
		{
			length += tracks.get(i).getLength();
		}
		return length;
	}
	
	@Override
	public void play()
	{
		System.out.println("Playing CD: ");
		System.out.println("Artist: " + artist);
		for(int i = 0; i < tracks.size(); i++)
		{
			tracks.get(i).play();
		}
	}
	
    @Override
    public String toString() {
        return "CD - [" + getId() + "] " + getTitle() 
               + " - " + getCategory() 
               + " - " + getDirector() 
               + " - " + getArtist() 
               + " - " + getLength() + " mins - " + getCost() + "$";
    }
}
