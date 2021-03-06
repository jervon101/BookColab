package nyc.c4q.book;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jervon.arnoldd on 12/18/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    View view;
    List<Book> books;
    Book book;
    private SharedPreferences log;
    Button button2;


    public BookAdapter(List<Book> books, SharedPreferences log) {
        this.books = books;
        this.log = log;
    }

    public BookAdapter(List<Book> cart) {
        this.books = cart;

    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(final BookHolder holder, int position) {


        book = books.get(position);

        holder.box.setClickable(false);

        holder.name.setText(book.getName());
        holder.series.setText(book.getSeries_t());
        holder.sequence.setText(String.valueOf(book.getSequence_i()));
        holder.author.setText(book.getAuthor());
        holder.genre.setText(book.getGenre_s());
        holder.price.setText(String.valueOf(book.getPrice()));


        if (book.isInStock()) {
            holder.box.setChecked(true);
        }

//
//        if (holder.chartBox.isChecked()) {
//
//        }

//
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    if (!book.getLink().isEmpty()) {
//                        Intent mServiceIntent = new Intent(view.getContext(), DoStuff.class);
//                        mServiceIntent.setData(Uri.parse(book.getLink()));
//                        view.getContext().startService(mServiceIntent);}
//                } catch (NullPointerException e) {
//                    Toast.makeText(view.getContext(), "Cant Download,Not link Present", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = log.edit();

//                if (log.contains(book.getName())) {
                Gson gson = new Gson();
                String json = gson.toJson(book);
                editor.putString(book.getName(), json);
                editor.commit();
//                }
            }
        });



        holder.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = log.edit();
                editor.remove(book.getName());
                editor.commit();
                notifyDataSetChanged();
            }
        });


        holder.setBooks(book);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {

        TextView name, series, sequence, author, genre, price;
        CheckBox box, chartBox;
        Button button, cartButton;
        Book book;

        public void setBooks(Book book) {
            this.book = book;
        }

        public BookHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            series = (TextView) itemView.findViewById(R.id.series);
            sequence = (TextView) itemView.findViewById(R.id.sequence);
            author = (TextView) itemView.findViewById(R.id.author);
            genre = (TextView) itemView.findViewById(R.id.genre);
            price = (TextView) itemView.findViewById(R.id.price);
            box = (CheckBox) itemView.findViewById(R.id.box);

            button = (Button) itemView.findViewById(R.id.button);
            cartButton = (Button) itemView.findViewById(R.id.cartbutton);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", book.getName());
                    bundle.putString("series", book.getSeries_t());
                    bundle.putInt("sequence", book.getSequence_i());
                    bundle.putString("author", book.author);
                    bundle.putString("genre", book.getGenre_s());
                    bundle.putDouble("price", book.getPrice());
                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
