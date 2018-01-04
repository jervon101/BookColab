package nyc.c4q.book;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cartactivity extends AppCompatActivity {

    private SharedPreferences log;

    private static final String SHARED_PREF_KEY = "book_cart";

    public static List<Book> cart;


    RecyclerView recyclerView;
    Button cartbutton , button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartactivity);

//        button = (Button) findViewById(R.id.button);
//        button.setVisibility(View.GONE);
//
//        cartbutton = (Button) findViewById(R.id.cartbutton);
//        cartbutton.setVisibility(View.VISIBLE);


        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);

        cart = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.cartcycle);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(manager);


        Map<String, ?> keys = log.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());

            Gson gson = new Gson();
            String json = log.getString(entry.getKey(), "");
            Book obj = gson.fromJson(json, Book.class);
            cart.add(obj);
        }


        recyclerView.setAdapter(new BookAdapter(cart));





    }
}
