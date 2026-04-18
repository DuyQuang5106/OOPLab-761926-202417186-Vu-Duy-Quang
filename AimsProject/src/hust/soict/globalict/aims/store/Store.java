package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Media;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();
	public Store() {
		// TODO Auto-generated constructor stub
	}
	public void addMedia(Media m)
	{
			if(itemsInStore.contains(m))
			{
				System.out.println("addMedia: Error! This media is already in the cart!");
				return;
			}
		itemsInStore.add(m);
		System.out.println("addMedia: Successfully added media to the cart");
	}
	public void removeMedia(Media m)
	{
		if(itemsInStore.contains(m))
		{
				itemsInStore.remove(m);
				System.out.println("removeMedia: Successfully removed media: ");
				return;
		}
		System.out.println("removeMedia: Error! Media was not found in the cart");
	}
	
	public void printStore()
	{
		for(int i = 0; i < itemsInStore.size(); i++)
		{
			System.out.println(itemsInStore.get(i));
		}
	}
	
	public Media findByTitle(String s)
	{
		for(int i = 0; i < itemsInStore.size(); i++)
		{
			if(s.equals(itemsInStore.get(i).getTitle()))
			{
				return itemsInStore.get(i);
			}
		}
		return null;
	}
}
