package nyc.c4q.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView name, series, sequence, author, genre, price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initViews();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nameString = "Name: " + bundle.getString("name");
        String seriesString = "Series: " + bundle.getString("series");
        String sequenceString = "Secquence: " + String.valueOf(bundle.getInt("sequence"));
        String authorString = "Author: " + bundle.getString("author");
        String genreString = "Genre: " + bundle.getString("genre");
        String priceString = "Price: " + String.valueOf(bundle.getDouble("price"));


        name.setText(nameString);
        series.setText(seriesString);
        sequence.setText(sequenceString);
        author.setText(authorString);
        genre.setText(genreString);
        price.setText(priceString);
    }

    private void initViews() {
        name = (TextView) findViewById(R.id.name);
        series = (TextView) findViewById(R.id.series);
        sequence = (TextView) findViewById(R.id.sequence);
        author = (TextView) findViewById(R.id.author);
        genre = (TextView) findViewById(R.id.genre);
        price = (TextView) findViewById(R.id.price);
    }
}
