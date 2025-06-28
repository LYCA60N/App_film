package com.example.projectfilm.ui.user.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.projectfilm.R;
import com.example.projectfilm.ui.user.booking.Ticketbooking;

public class MovieDetailFragment extends Fragment {

    private static final String ARG_MOVIE = "movie";
    private Movie movie;

    // Tạo fragment với movie truyền vào
    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = (Movie) getArguments().getSerializable(ARG_MOVIE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageBanner = view.findViewById(R.id.imageBanner);
        TextView textTitle = view.findViewById(R.id.textTitle);
        TextView textDescription = view.findViewById(R.id.textDescription);
        TextView textGener = view.findViewById(R.id.textGener);
        TextView textDuration = view.findViewById(R.id.textDuration);
        TextView textStatus = view.findViewById(R.id.textStatus);
        TextView textPrice = view.findViewById(R.id.textPrice);
        Spinner spinnerDates = view.findViewById(R.id.spinnerDates);
        Spinner spinnerCinema = view.findViewById(R.id.spinnerCinema);
        Spinner spinnerQuantity = view.findViewById(R.id.spinnerQuantity);
        GridLayout gridTimes = view.findViewById(R.id.gridTimes);
        Button btnBookTicket = view.findViewById(R.id.btnBookTicket);

        if (movie != null) {
            textTitle.setText(movie.getTitle());
            textDescription.setText(movie.getDescription());
            textGener.setText(movie.getGenre());
            textStatus.setText(movie.getStatus());
            textDuration.setText("120 phút"); // Bạn có thể thay bằng movie.getDuration() nếu có
            textPrice.setText("Giá: " + movie.getTicketPrice() + " VND");

            Glide.with(requireContext())
                    .load(movie.getImageUrl())
                    .placeholder(R.drawable.placeholder)
                    .into(imageBanner);
        }

        // Sự kiện khi bấm "Đặt vé"
        btnBookTicket.setOnClickListener(v -> {
            if (movie != null) {
                Intent intent = new Intent(requireContext(), Ticketbooking.class);
                intent.putExtra("movie", movie); // Movie cần implements Serializable
                startActivity(intent);
            }
        });
    }
}
