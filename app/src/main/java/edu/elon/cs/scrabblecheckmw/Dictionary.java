package edu.elon.cs.scrabblecheckmw;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by crowcasso on 8/28/15.
 */
public class Dictionary {

    private ArrayList<String> theWords;

    public Dictionary(Context context) {

        theWords = new ArrayList<String>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("dictionary.txt"), "UTF-8"));

            String aLine = reader.readLine();
            while (aLine != null) {
                theWords.add(aLine);
                aLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {

                }
            }
        }
    }

}
