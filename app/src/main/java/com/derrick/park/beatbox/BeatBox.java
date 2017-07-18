package com.derrick.park.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 2017/07/18.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SAMPLE_SOUNDS = "sample_sounds";
    private AssetManager mAssets;
    private ArrayList<Sound> mSounds = new ArrayList<>();


    public BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundsNames;
        try {
            soundsNames = mAssets.list(SAMPLE_SOUNDS);
            Log.i(TAG, "loadSounds: Found " + soundsNames.length + " sounds.");
        } catch (IOException ioe) {
            Log.e(TAG, "loadSounds: Could not list assets", ioe);
            return;
        }

        for (String filename : soundsNames) {
            String assetPath = SAMPLE_SOUNDS + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;

    }
}
