package com.example.crickinfo.ui.transform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crickinfo.R;
import com.example.crickinfo.databinding.FragmentTransformBinding;
import com.example.crickinfo.databinding.ItemTransformBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Arrays;
import java.util.List;

/**
 * Fragment that demonstrates a responsive layout pattern where the format of the content
 * transforms depending on the size of the screen. Specifically this Fragment shows items in
 * the [RecyclerView] using LinearLayoutManager in a small screen
 * and shows items using GridLayoutManager in a large screen.
 */
public class MatchFragment extends Fragment {

    private FragmentTransformBinding binding;
    private List<Match> matches = new ArrayList<>();
    private MatchAdapter matchAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TransformViewModel transformViewModel =
                new ViewModelProvider(this).get(TransformViewModel.class);

        binding = FragmentTransformBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        matchAdapter = new MatchAdapter(matches, this::editMatch);
        binding.recyclerviewTransform.setAdapter(matchAdapter);

        setupCreateMatchForm(root);
        setupEmailIcon(root);

        return root;
    }

    private void setupEmailIcon(View root) {
        ImageView emailIcon = root.findViewById(R.id.email_icon);
        emailIcon.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Create Match");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Fill out the match details in the app.");
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });
    }

    private void setupCreateMatchForm(View root) {
        EditText matchNameInput = root.findViewById(R.id.match_name_input);
        EditText placeInput = root.findViewById(R.id.place_input);
        EditText oversInput = root.findViewById(R.id.overs_input);
        EditText maxOversInput = root.findViewById(R.id.max_overs_input);
        EditText extraRunInput = root.findViewById(R.id.extra_run_input);
        Button dateButton = root.findViewById(R.id.date_button);
        Button createButton = root.findViewById(R.id.create_match_button);

        final Calendar calendar = Calendar.getInstance();
        final int[] selectedDate = new int[3];

        dateButton.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
                selectedDate[0] = year;
                selectedDate[1] = month;
                selectedDate[2] = dayOfMonth;
                dateButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        createButton.setOnClickListener(v -> {
            String matchName = matchNameInput.getText().toString();
            String place = placeInput.getText().toString();
            int numberOfOvers = Integer.parseInt(oversInput.getText().toString());
            int maxOversPerBowler = Integer.parseInt(maxOversInput.getText().toString());
            int wideNoBallExtraRunValue = Integer.parseInt(extraRunInput.getText().toString());

            Calendar matchDate = Calendar.getInstance();
            matchDate.set(selectedDate[0], selectedDate[1], selectedDate[2]);

            Match match = new Match(matchName, matchDate.getTime(), place, numberOfOvers, maxOversPerBowler, wideNoBallExtraRunValue);
            matches.add(match);
            matchAdapter.notifyDataSetChanged();

            Toast.makeText(getContext(), "Match created successfully!", Toast.LENGTH_SHORT).show();
        });
    }

    private void editMatch(int position) {
        Match match = matches.get(position);
        // Logic to populate the form with match details for editing
        // Update the match in the list after editing
        matches.set(position, match);
        matchAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private static class TransformAdapter extends ListAdapter<String, TransformViewHolder> {

        private final List<Integer> drawables = Arrays.asList(
                R.drawable.avatar_1,
                R.drawable.avatar_2,
                R.drawable.avatar_3,
                R.drawable.avatar_4,
                R.drawable.avatar_5,
                R.drawable.avatar_6,
                R.drawable.avatar_7,
                R.drawable.avatar_8,
                R.drawable.avatar_9,
                R.drawable.avatar_10,
                R.drawable.avatar_11,
                R.drawable.avatar_12,
                R.drawable.avatar_13,
                R.drawable.avatar_14,
                R.drawable.avatar_15,
                R.drawable.avatar_16);

        protected TransformAdapter() {
            super(new DiffUtil.ItemCallback<String>() {
                @Override
                public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                    return oldItem.equals(newItem);
                }
            });
        }

        @NonNull
        @Override
        public TransformViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemTransformBinding binding = ItemTransformBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new TransformViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull TransformViewHolder holder, int position) {
            holder.textView.setText(getItem(position));
            holder.imageView.setImageDrawable(
                    ResourcesCompat.getDrawable(holder.imageView.getResources(),
                            drawables.get(position),
                            null));
        }
    }

    private static class TransformViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public TransformViewHolder(ItemTransformBinding binding) {
            super(binding.getRoot());
            imageView = binding.imageViewItemTransform;
            textView = binding.textViewItemTransform;
        }
    }
}