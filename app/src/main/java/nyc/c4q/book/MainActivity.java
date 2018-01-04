package nyc.c4q.book;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static List<Book> cart;

    private SharedPreferences log;
    private static final String SHARED_PREF_KEY = "book_cart";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView = (RecyclerView) findViewById(R.id.cycle);
        recyclerView.setLayoutManager(manager);
        RetroSetup();

        cart = new ArrayList<>();

        Map<String, ?> keys = log.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());

            Gson gson = new Gson();
            String json = log.getString(entry.getKey(), "");
            Book obj = gson.fromJson(json, Book.class);
            cart.add(obj);
        }

        Log.e("Size", cart.size() + "");
    }

    public void RetroSetup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<Book>> call = api.getBook();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Log.e("works is:", "Helo");
                List<Book> books = response.body();
                recyclerView.setAdapter(new BookAdapter(books, log));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Error", t.getMessage());
            }
        });
    }
}
