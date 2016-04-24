package com.example.project.forrent;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Michael on 4/23/2016.
 */
public final class Storage {
    private Storage() {}

    public static void writeObject(Context context, String name, Object object) throws IOException {
        FileOutputStream fos = context.openFileOutput(name, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    public static Object readObject(Context context, String key) throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput(key);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        if (object == null) {
            Log.w("testinglog", "the object is null &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        } else {
            Log.w("testinglog", "the object is real &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        }
        return object;
    }

    public static boolean fileExists(Context context, String name){
        File file = context.getFileStreamPath(name);
        return !(file == null || !file.exists());
    }
}
