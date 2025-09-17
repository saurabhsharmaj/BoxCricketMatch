package com.example.crickinfo.ui.transform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crickinfo.R;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private final List<Match> matches;
    private final OnMatchClickListener onMatchClickListener;

    public MatchAdapter(List<Match> matches, OnMatchClickListener onMatchClickListener) {
        this.matches = matches;
        this.onMatchClickListener = onMatchClickListener;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.matchName.setText(match.getMatchName());
        holder.matchDate.setText(match.getDate().toString());
        holder.matchPlace.setText(match.getPlace());

        holder.itemView.setOnClickListener(v -> onMatchClickListener.onMatchClick(position));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public interface OnMatchClickListener {
        void onMatchClick(int position);
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView matchName;
        TextView matchDate;
        TextView matchPlace;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            matchName = itemView.findViewById(R.id.match_name);
            matchDate = itemView.findViewById(R.id.match_date);
            matchPlace = itemView.findViewById(R.id.match_place);
        }
    }
}
