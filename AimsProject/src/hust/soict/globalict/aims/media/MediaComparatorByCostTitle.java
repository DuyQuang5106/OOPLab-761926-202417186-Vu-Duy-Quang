package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(Media a, Media b)
	{
		if(a.getCost() > b.getCost()) return -1;
		else if (a.getCost() < b.getCost()) return 1;
		else
		{
			if (a.getTitle() == null && b.getTitle() == null) return 0;
            if (a.getTitle() == null) return 1;
            if (b.getTitle() == null) return -1;

            return a.getTitle().compareTo(b.getTitle());
		}
	}
}
