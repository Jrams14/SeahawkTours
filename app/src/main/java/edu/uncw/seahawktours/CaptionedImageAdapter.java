package edu.uncw.seahawktours;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    private Listener listener;
    private List<Building> buildingList;
    private Context context;

    interface Listener {
        void onClick(int position);
    }

    public CaptionedImageAdapter(List<Building> buildings,Context context) {
        this.buildingList = buildings;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @Override
    public CaptionedImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {

        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        int buildingImage = context.getResources().getIdentifier(buildingList.get(position).getImage(),"drawable",context.getPackageName());
        imageView.setImageResource(buildingImage);
        imageView.setContentDescription(buildingList.get(position).getName());
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(buildingList.get(position).getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
            });
    }



}
