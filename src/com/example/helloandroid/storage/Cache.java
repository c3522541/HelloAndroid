package com.example.helloandroid.storage;

import android.graphics.Bitmap;
import android.os.Environment;

public class Cache {
    private static CacheStore cache = CacheStore.getInstance();
   
    public static boolean isCacheAvailable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state) ) {
            return true;
        } else {
            return false;
        }
    }
   
    public static boolean isCacheWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        } else {
            return false;
        }
    }
   
    public static void saveCacheFile(String cacheUri, Bitmap image) {
        if(!isCacheWritable()) return;
        cache.saveCacheFile(cacheUri, image);
    }
    public static Bitmap getCacheFile(String cacheUri) {
        if(!isCacheAvailable()) return null;
       
        return cache.getCacheFile(cacheUri);
    }
}