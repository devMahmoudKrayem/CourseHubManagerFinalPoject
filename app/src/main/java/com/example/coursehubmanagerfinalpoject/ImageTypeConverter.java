package com.example.coursehubmanagerfinalpoject;

import android.net.Uri;

import androidx.room.TypeConverter;

public class ImageTypeConverter {
    @TypeConverter
    public static String fromUri(Uri uri) {
        return uri == null ? null : uri.toString();
    }

    // Convert String back to Uri when reading from the database
    @TypeConverter
    public static Uri toUri(String uriString) {
        return uriString == null ? null : Uri.parse(uriString);
    }

}
