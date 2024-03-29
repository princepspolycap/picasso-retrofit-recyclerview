package com.mac.appretrofit;

import com.mac.appretrofit.model.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by anyer on 7/7/15.
 */
public interface GitHubService {
    @GET("/users/{user}/repos")
    List<Repo> listRepos(@Path("user") String user);
}
