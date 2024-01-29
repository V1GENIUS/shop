package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.R;
import com.example.shop.categoryModal;

import java.util.ArrayList;

public class RecycleCatgeoryAdapter extends RecyclerView.Adapter<RecycleCatgeoryAdapter.viewHolder> {
    Context context;
    ArrayList<categoryModal> arrCategories = new ArrayList<categoryModal>();
    public RecycleCatgeoryAdapter(Context context, ArrayList<categoryModal> arrCategories)
    {
        this.context = context;
        this.arrCategories = arrCategories;

       // this.arrCategories = (arrCategories != null) ? arrCategories : new ArrayList<>();



    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cat_row, parent, false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.image.setImageResource(arrCategories.get(position).image);
        holder.cat_name.setText(arrCategories.get(position).Cat_name);
        holder.cat_des.setText(arrCategories.get(position).cat_des);

    }

    @Override
    public int getItemCount() {
        return arrCategories.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView cat_name , cat_des;
        ImageView image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            cat_name = itemView.findViewById(R.id.cat_name);
            cat_des = itemView.findViewById(R.id.cat_des);
            image = itemView.findViewById(R.id.image);
        }
    }
}
