package ga.himanshu.home.myapplicationm;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Himanshu on 4/16/2016.
 */
public class JsonLoader extends AsyncTask<JsonRequest,Void,Void> {

    private final String API_URL="https://api.backand.com/1/objects/text";
    private final String ANNONYMOUS_TOKEN="ba68b32a-03f4-4e77-bd9a-60189810d6d3";


    @Override
    protected Void doInBackground(JsonRequest... params) {
        JsonRequest request=params[0];
        String jh=request.mobile;

        try{

            String urlstring=API_URL;
            URL url =new URL(urlstring);

            HttpURLConnection connection=(HttpURLConnection)url.openConnection();

            connection.setRequestProperty("AnonymousToken", ANNONYMOUS_TOKEN);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(jh);
            wr.flush();
            wr.close();
            InputStream stream=connection.getInputStream();

            BufferedReader r=new BufferedReader(new InputStreamReader(stream));
            String totalresponse="";
            String line;



        }catch (Exception e){

        }

        return null;
    }
}
