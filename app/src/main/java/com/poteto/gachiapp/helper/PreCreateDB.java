package com.poteto.gachiapp.helper;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PreCreateDB {

    public static void createDB (Context context) {

        String pathFileName = "/data/data/" + context.getPackageName() + "/databases/gachiDB";

        String pathDb = "/data/data/" + context.getPackageName() + "/databases";
        File fPath = new File(pathDb);

        if(!fPath.exists()){
            fPath.mkdirs();
            try{
                InputStream input = context.getAssets().open("gachiDB");
                OutputStream output = new FileOutputStream(pathFileName);
                copyDB(input, output);
                Log.d("gachi_DB", "DB successfully copied");
            } catch (Exception e) {
                Log.d("gachi_DB", "Error while trying to copy the DB");
                e.printStackTrace();
            }
        }else{
            try{
                InputStream input = context.getAssets().open("gachiDB");
                OutputStream output = new FileOutputStream(pathFileName);
                copyDB(input, output);
                Log.d("gachi_DB", "DB successfully copied");
            } catch (Exception e) {
                Log.d("gachi_DB", "Error while trying to copy the DB");
                e.printStackTrace();
            }
        }
    }

    private static void copyDB(InputStream input, OutputStream output) throws IOException {
            int i;
            byte[] buffer = new byte[1024];
            while((i = input.read(buffer)) > 0){
                output.write(buffer, 0, i);
            }
            input.close();
            output.close();
            Log.d("gachi_DB", "DB successfully copied");
    }
}
