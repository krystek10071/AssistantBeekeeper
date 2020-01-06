package com.example.assistantbeekeeper.weatherwitget;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NetworkUtils {

    private static final String TAG="NETWORK";

    private final static String WHEATHER_5_DAY_URL=
            "http://dataservice.accuweather.com/forecasts/v1/daily/5day/274231";

    private final static String API_KEY="bDGjT2yEX1J5CGJAC7lpPImJztQAmwcp";

    private final static String PARAM_KEY="api_key";

    public static URL buildUrlWeather(){
        Uri builUri=Uri.parse(WHEATHER_5_DAY_URL).buildUpon()
                .appendQueryParameter(PARAM_KEY, API_KEY).build();


        URL urlAddress=null;

        try{
            urlAddress=new URL(builUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "build Url Wather"+ urlAddress);
        return  urlAddress;
    }

    public static String getResponseFromUrl(URL url)throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream responseBody = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(responseBody);
            scanner.useDelimiter("\\A");                                                    //??????

            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                return null;
            }


        }finally {
            httpURLConnection.disconnect();
        }

    }
}
