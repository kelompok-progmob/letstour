package com.progmob.letstour.utils;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.progmob.letstour.R;


public class YoutubePlayerViewActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final int REQUEST_NUMBER = 999;
    private YouTubePlayerView youTubePlayerView;
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player_view);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view_YoutubePlayerView);
        youTubePlayerView.initialize("AIzaSyA0KCIjEXYt79gqVdS5YpKMKKRjzE88_zY",this);


    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){

            Bundle dataExtra = getIntent().getExtras();

            String id = dataExtra.getString("idThumbnailExtra");

            youTubePlayer.loadVideo(id);
            /**
             * there are 2 method you can user here :
             * .cueVideo(), for didn't play automatically
             * .loadVideo(), for do play automatically
             *
             * if you are using play automatically, it better if you hide the video controllers
             * do like below :
             *
              *youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);//hide the players controllers
            */
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, REQUEST_NUMBER).show();
        }else{
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)", youTubeInitializationResult.toString()
            );
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_NUMBER){
            youTubePlayerView.initialize("AIzaSyA0KCIjEXYt79gqVdS5YpKMKKRjzE88_zY",this);
        }
    }
}
