package com.example.helloandroid.utilities;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.helloandroid.R;
import com.example.helloandroid.storage.Cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    private String url;
    private final WeakReference<ImageView> imageViewReference;

    public ImageDownloader(ImageView imageView) {
        imageViewReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        url = params[0];
        try {
            return BitmapFactory.decodeStream(new URL(url).openConnection()
                    .getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (isCancelled()) {
            result = null;
        }
        if (imageViewReference != null) {
            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(result);
            }
        }
        Cache.saveCacheFile(url, result);
    }

    @Override
    protected void onPreExecute() {
        if (imageViewReference != null) {
            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon);
            }
        }
    }
}