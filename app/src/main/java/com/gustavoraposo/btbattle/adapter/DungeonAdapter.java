package com.gustavoraposo.btbattle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DungeonAdapter extends RecyclerView.Adapter<DungeonAdapter.DungeonViewHolder> {

    private List<DungeonFloor> mList = new ArrayList<>();
    private LayoutInflater mInflater;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public DungeonAdapter(RecyclerViewClickInterface recyclerViewClickInterface) {
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @NotNull
    @Override
    public DungeonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dungeon_floor, parent, false);
        return new DungeonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DungeonViewHolder holder, int position) {
        holder.mTextViewItemDungeonName.setText(mList.get(position).getFloorName());
        holder.mTextViewItemDungeonMonster.setText(String.valueOf(mList.get(position).getMonsters()));
        holder.mTextViewItemDungeonLevel.setText(
                String.format(
                        "Lvl %s ~ %s",
                        String.valueOf(mList.get(position).getMinLevel()),
                        String.valueOf(mList.get(position).getMaxLevel())
                )
        );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<DungeonFloor> list){
        mList = list;
        notifyDataSetChanged();
    }

    public class DungeonViewHolder extends RecyclerView.ViewHolder {

        public MaterialTextView mTextViewItemDungeonName;
        public MaterialTextView mTextViewItemDungeonMonster;
        public MaterialTextView mTextViewItemDungeonLevel;

        public DungeonViewHolder(View itemView) {
            super(itemView);

            mTextViewItemDungeonName = itemView.findViewById(R.id.textViewItemDungeonFloorName);
            mTextViewItemDungeonMonster = itemView.findViewById(R.id.textViewItemDungeonFloorMonster);
            mTextViewItemDungeonLevel = itemView.findViewById(R.id.textViewItemDungeonFloorLevel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(view ->{
                recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
                return true;
            });
        }
    }
}
