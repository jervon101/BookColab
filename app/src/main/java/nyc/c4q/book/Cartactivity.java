package nyc.c4q.book;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class Cartactivity extends AppCompatActivity {

    private SharedPreferences log;

    private static final String SHARED_PREF_KEY = "book_cart";

//    public static List<Book> cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartactivity);


        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);



//        Map<String,?> keys = log.getAll();
//
//        for(Map.Entry<String,?> entry : keys.entrySet()){
//            Log.d("map values",entry.getKey() + ": " +entry.getValue().toString());
//
//            Gson gson = new Gson();
//            String json = log.getString(entry.getKey(), "");
//            Book obj = gson.fromJson(json, Book.class);
//            cart.add(obj);
//        }




    }
}
