package com.mac.appretrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mac.appretrofit.model.Repo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RestAdapter restAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
        final GitHubService service = restAdapter.create(GitHubService.class);

        setupRecyclerView();

        new AsyncTask<Void, Void, List<Repo>>(){

            @Override
            protected List<Repo> doInBackground(Void... params) {
                List<Repo> repoList = service.listRepos("anyercastillo");

                return repoList;
            }

            @Override
            protected void onPostExecute(List<Repo> repoList) {
                super.onPostExecute(repoList);

                GitHubAdapter adapter = (GitHubAdapter) mRecyclerView.getAdapter();
                adapter.getRepoList().addAll(repoList);
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new GitHubAdapter(this, new ArrayList<Repo>()));
    }
}
