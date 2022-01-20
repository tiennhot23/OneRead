package com.example.oneread.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.oneread.Model.Book;
import com.example.oneread.R;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerDrawable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    Context context;
    List<Book> books = new ArrayList<>();
    HashMap<String, Boolean> isFollowed = new HashMap<>();
    public BookAdapter() {
    }

    public BookAdapter(Context context, List<Book> books, HashMap<String, Boolean> isFollowed) {
        this.context = context;
        this.books = books;
        this.isFollowed = isFollowed;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.comic_item, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Shimmer shimmer = new Shimmer.ColorHighlightBuilder()
                .setBaseColor(Color.parseColor("#F3F3F3")).setBaseAlpha(1).setHighlightColor(Color.parseColor("#E7E7E7"))
                .setHighlightAlpha(1).setDropoff(50).build();
        ShimmerDrawable shimmerDrawable = new ShimmerDrawable();
        shimmerDrawable.setShimmer(shimmer);
        Picasso.get().load(books.get(position).getThumb()).placeholder(shimmerDrawable).into(holder.thumb);
        if(isFollowed.containsKey(books.get(position).getEndpoint()))
            holder.btn_follow.setImageResource(R.drawable.ic_marked);
        else
            holder.btn_follow.setImageResource(R.drawable.ic_mark);
        holder.btn_follow.setTag(position);
        holder.title_comic.setText(books.get(position).getTitle());
        holder.rating.setText(String.valueOf(books.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thumb;
        TextView title_comic, title_chapter, rating;
        ImageView btn_follow;
        Toast toast = null;
        public ViewHolder( View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.thumb);
            title_comic = itemView.findViewById(R.id.title_comic);
            title_chapter = itemView.findViewById(R.id.title_chapter);
            rating = itemView.findViewById(R.id.rating);
            btn_follow = itemView.findViewById(R.id.btn_follow);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, DetailComicActivity.class);
//                    intent.putExtra("endpoint", books.get(getAdapterPosition()).getEndpoint());
//                    context.startActivity(intent);
                }
            } );

            btn_follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if(toast != null) toast.cancel();
//                    if(btn_follow.getDrawable().getConstantState().equals(context.getResources().getDrawable(R.drawable.ic_mark).getConstantState())){
//                        btn_follow.setImageResource(R.drawable.ic_marked);
//                        toast = Toast.makeText(context, "Followed", Toast.LENGTH_SHORT);
//                        toast.show();
//                        MainActivity.followedComicViewModel.insert(new FollowedComic(books.get(getBindingAdapterPosition()).endpoint));
//                        if(!isFollowed.containsKey(books.get((Integer) btn_follow.getTag()).endpoint)){
//                            isFollowed.put(books.get((Integer) btn_follow.getTag()).endpoint, true);
////                            FollowedFragment.listFollowedComic.add(books.get((Integer) btn_follow.getTag()));
//                        }
//                    }else{
//                        btn_follow.setImageResource(R.drawable.ic_mark);
//                        toast = Toast.makeText(context, "Unollowed", Toast.LENGTH_SHORT);
//                        toast.show();
//                        MainActivity.followedComicViewModel.delete(new FollowedComic(books.get(getBindingAdapterPosition()).endpoint));
//                        if(isFollowed.containsKey(books.get((Integer) btn_follow.getTag()).endpoint)){
//                            isFollowed.remove(books.get((Integer) btn_follow.getTag()).endpoint);
////                            FollowedFragment.listFollowedComic.remove(books.get((Integer) btn_follow.getTag()));
//                        }
//                    }
                }
            });
        }
    }
}