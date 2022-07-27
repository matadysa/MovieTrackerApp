package com.example.movietrackerapp.Listeners;

import com.example.movietrackerapp.Models.SearchApiResponse;

public interface OnSearchApiListener {
    void onResponse(SearchApiResponse response);
    void onError(String message);
}
