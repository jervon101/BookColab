package nyc.c4q.book;

import java.util.List;

/**
 * Created by jervon.arnoldd on 12/13/17.
 */

public class Book {


    String id;
    List <String> cat;
    String name;
    String author;
    String series_t;
    int sequence_i;
    String genre_s;
    boolean inStock;
    double price;
    int pages_i;
    String link;


    public String getLink() {
        return link;
    }

    public String getId() {
        return id;
    }

    public List<String> getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public int getSequence_i() {
        return sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public boolean isInStock() {
        return inStock;
    }

    public double getPrice() {
        return price;
    }

    public int getPages_i() {
        return pages_i;
    }
}



