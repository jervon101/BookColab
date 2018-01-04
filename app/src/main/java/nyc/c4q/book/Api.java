package nyc.c4q.book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jervon.arnoldd on 12/13/17.
 */

public interface Api {

    String BASE_URL = "https://raw.githubusercontent.com/tamingtext/book/master/apache-solr/example/exampledocs/";


    @GET("books.json")
    Call<List<Book>> getBook();

}
