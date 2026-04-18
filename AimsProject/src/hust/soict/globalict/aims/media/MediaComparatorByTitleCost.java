package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media a, Media b) {

        if (a.getTitle() == null && b.getTitle() == null) return 0;
        if (a.getTitle() == null) return 1;
        if (b.getTitle() == null) return -1;

        int titleCompare = a.getTitle().compareTo(b.getTitle());

        if (titleCompare != 0) {
            return titleCompare;          
        } else {

            if (a.getCost() > b.getCost()) {
                return -1; 
            } else if (a.getCost() < b.getCost()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}