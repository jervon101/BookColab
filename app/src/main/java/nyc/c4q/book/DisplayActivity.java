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

        name.setText(bundle.getString("name"));
        series.setText(bundle.getString("series"));
        sequence.setText(bundle.getString("sequence"));
        author.setText(bundle.getString("author"));
        genre.setText(bundle.getString("genre"));
        price.setText(bundle.getString("price"));
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
