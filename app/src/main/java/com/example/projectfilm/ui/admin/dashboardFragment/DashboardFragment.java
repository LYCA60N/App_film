package com.example.projectfilm.ui.admin.dashboardFragment;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

import androidx.navigation.Navigation;

import com.example.projectfilm.R;


public class DashboardActivity extends Fragment {

    private Button btnManageMovies, btnManageUsers;

    public DashboardActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin_dashboard, container, false);

        // Initialize buttons
        btnManageMovies = view.findViewById(R.id.btn_manage_movies);
        btnManageUsers = view.findViewById(R.id.btn_manage_users);
        if (btnManageMovies == null) {
            Log.e("DashboardFragment", "btn_manage_movies is NULL! Check admin_dashboard.xml ID.");
        }
        if (btnManageUsers == null) {
            Log.e("DashboardFragment", "btn_manage_users is NULL! Check admin_dashboard.xml ID.");
        } else {
            Log.d("DashboardFragment", "btn_manage_users found successfully.");
        }
        // Navigate to Movie Management screen
        btnManageMovies.setOnClickListener(v -> {
            // Sử dụng Navigation.findNavController(v) là cách ngắn gọn và được ưa chuộng hơn trong Fragment
            Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_movieManageFragment);
        });

        // Navigate to User Management screen
        btnManageUsers.setOnClickListener(v -> {
            // Sử dụng Navigation.findNavController(v) thay vì Navigation.findNavController(requireActivity(), ...)
            Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_userManageFragment);
        });

        return view;
    }
}