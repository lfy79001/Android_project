package com.example.taobaounion5.model;

import com.example.taobaounion5.model.domain.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APi {

    @GET("discovery/categories")
    Call<Categories> getCategories();
}
