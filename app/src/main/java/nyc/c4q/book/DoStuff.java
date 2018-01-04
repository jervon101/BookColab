package nyc.c4q.book;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by jervon.arnoldd on 12/18/17.
 */

public class DoStuff extends IntentService {
    public DoStuff(String name) {
        super(name);
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

//    public DoStuff() {
//        super();
//    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
//        String dataString = workIntent.getDataString();
    }
}
