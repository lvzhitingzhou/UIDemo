package com.saku.uidemo.activities.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saku.uidemo.R;
import com.saku.uidemo.data.MyText;
import com.saku.uidemo.utils.ExpandableVHUtils;

import java.util.List;
import java.util.Random;

public class ListTextAdapter extends RecyclerView.Adapter<ListTextAdapter.TextHolder>{

    private final List<MyText> data;
    private final Context mContext;
    private Random mRandom = new Random(255);
    private final KeepOne<TextHolder> mKeepOne;

    public ListTextAdapter(Context c, List<MyText> data){
        this.data = data;
        this.mContext = c;

        mKeepOne = new KeepOne<TextHolder>();
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_mytext, parent, false);

        TextHolder holder = new TextHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final TextHolder holder, final int position) {
        final MyText myText = data.get(position);
        holder.title.setText(myText.title);
        holder.desc.setText(myText.desc);

        mKeepOne.bind(holder, position);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKeepOne.toggle(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class TextHolder extends RecyclerView.ViewHolder implements Expandable{
        public TextView title;
        public TextView desc;
        public TextHolder(View itemView) {
            super(itemView);
            int color = Color.rgb(mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
            itemView.setBackgroundColor(color);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
        }

        @Override
        public View getExpandView() {
            return desc;
        }
    }



    public static class KeepOne<VH extends RecyclerView.ViewHolder & Expandable>{
        private int openPos = -1;

        public void bind(VH holder, int position) {
            if (openPos == position) {
                ExpandableVHUtils.open(holder, holder.getExpandView(), false);
            } else {
                ExpandableVHUtils.close(holder, holder.getExpandView(), false);
            }
        }

        @SuppressWarnings("unchecked")
        public void toggle(VH holder, int position) {
            if (openPos == position) {
                openPos = -1;
                ExpandableVHUtils.close(holder, holder.getExpandView(), true);
            } else {
                int prev_openPos = openPos;
                openPos = position;
                ExpandableVHUtils.open(holder, holder.getExpandView(), true);

                // 关闭之前的动画
                final VH prevHolder = (VH) ((RecyclerView) holder.itemView.getParent()).findViewHolderForAdapterPosition(prev_openPos);
                if (prevHolder != null) {
                    ExpandableVHUtils.close(prevHolder, prevHolder.getExpandView(), true);
                }
            }
        }
    }

    public interface Expandable{
        View getExpandView();
    }
}

