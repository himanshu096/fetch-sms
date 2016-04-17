package ga.himanshu.home.myapplicationm;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Himanshu on 4/17/2016.
 */
public class MessageRespondService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MessageRespondService(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


    }
}
