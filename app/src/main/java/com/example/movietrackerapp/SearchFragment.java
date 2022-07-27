package com.example.movietrackerapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietrackerapp.Adapters.HomeRecyclerAdapter;
import com.example.movietrackerapp.Listeners.OnMovieClickListener;
import com.example.movietrackerapp.Listeners.OnSearchApiListener;
import com.example.movietrackerapp.Models.SearchApiResponse;

public class SearchFragment extends Fragment implements OnMovieClickListener {
    Context contextThemeWrapper;
    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Dark);
        } else {
            contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Light);
        }

        LayoutInflater layoutInflater = inflater.cloneInContext(contextThemeWrapper);

        View view = layoutInflater.inflate(R.layout.fragment_search, container, false);

        search_view = view.findViewById(R.id.search_view);
        recycler_view_home = view.findViewById(R.id.recycler_view_home);

        manager = new RequestManager(getActivity());

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //
                manager.searchMovies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        return view;
    }

    private final OnSearchApiListener listener = new OnSearchApiListener() {
        @Override
        public void onResponse(SearchApiResponse response) {
            if(response==null){
                Toast.makeText(getActivity(), "No data available!", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getActivity(), "an Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    };
    private void showResult(SearchApiResponse response) {
        recycler_view_home.setHasFixedSize(true);
        recycler_view_home.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new HomeRecyclerAdapter(getActivity(), response.getTitles(), this);
        recycler_view_home.setAdapter(adapter);
    }

    @Override
    public void OnMovieClick(String id) {
        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
    }
}
