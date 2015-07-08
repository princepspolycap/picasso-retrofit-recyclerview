package com.mac.appretrofit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anyer on 7/8/15.
 */
class GitHubViewHolder extends RecyclerView.ViewHolder {
    TextView mName;
    ImageView mPicture;

    public GitHubViewHolder(View v) {
        super(v);

        mName = (TextView) v.findViewById(R.id.repo_textview_name);
        mPicture = (ImageView) v.findViewById(R.id.repo_imageview_picture);
    }

    public TextView getTextViewName() {
        return mName;
    }

    public ImageView getPicture() {
        return mPicture;
    }
}
