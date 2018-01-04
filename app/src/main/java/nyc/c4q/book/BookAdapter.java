package nyc.c4q.book;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jervon.arnoldd on 12/18/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    View view;
    List<Book> books;
    Book book;

    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
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

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!book.getLink().isEmpty()) {
                        Intent mServiceIntent = new Intent(view.getContext(), DoStuff.class);
                        mServiceIntent.setData(Uri.parse(book.getLink()));
                        view.getContext().startService(mServiceIntent);}
                } catch (NullPointerException e) {
                    Toast.makeText(view.getContext(), "Cant Download,Not link Present", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {

        TextView name, series, sequence, author, genre, price;
        CheckBox box;
        Button button;

        public BookHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            series = (TextView) itemView.findViewById(R.id.series);
            sequence = (TextView) itemView.findViewById(R.id.sequence);
            author = (TextView) itemView.findViewById(R.id.author);
            genre = (TextView) itemView.findViewById(R.id.genre);
            price = (TextView) itemView.findViewById(R.id.price);
            box = (CheckBox) itemView.findViewById(R.id.box);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }
}