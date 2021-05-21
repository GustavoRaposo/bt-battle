package com.gustavoraposo.btbattle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.model.data.Player;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder> {

    private List<Player> mList = new ArrayList<>();
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public MonsterAdapter(RecyclerViewClickInterface recyclerViewClickInterface){
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @NotNull
    @Override
    public MonsterAdapter.MonsterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_floor_monster, parent, false);
        return new MonsterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MonsterAdapter.MonsterViewHolder holder, int position) {
        holder.mTextViewItemFloorMonsterName.setText(mList.get(position).getName());
        holder.mTextViewItemFloorMonsterLevel.setText(String.format("Lvl %d", mList.get(position).getLevel()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<Player> list){
        mList = list;
        notifyDataSetChanged();
    }

    public class MonsterViewHolder extends RecyclerView.ViewHolder{

        public MaterialTextView mTextViewItemFloorMonsterName;
        public MaterialTextView mTextViewItemFloorMonsterLevel;

        public MonsterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mTextViewItemFloorMonsterName = itemView.findViewById(R.id.textViewItemFloorMonsterName);
            mTextViewItemFloorMonsterLevel = itemView.findViewById(R.id.textViewItemFloorMonsterLevel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }

}
