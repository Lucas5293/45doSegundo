package com.mthumb.a45doSegundo.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CachedBitmap {

    private static Map<String, Bitmap> cache = new HashMap<>();

    public static Bitmap get(String url) throws IOException {
        if (!CachedBitmap.cache.containsKey(url)) {
            InputStream input= new URL(url).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            CachedBitmap.cache.put(url,bitmap);
        }
        return CachedBitmap.cache.get(url);
    }
}
