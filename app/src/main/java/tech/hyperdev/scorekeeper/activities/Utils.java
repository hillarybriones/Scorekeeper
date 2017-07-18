package tech.hyperdev.scorekeeper.activities;

import android.app.Activity;
import android.content.Intent;

import tech.hyperdev.scorekeeper.R;

/**
 * Created by Hillary Briones on 7/18/2017.
 */

public class Utils {
    private static int sTheme;
    public final static int DAY_MODE = 0;
     public final static int NIGHT_MODE = 1;

          public static void changeToTheme(Activity activity, int theme) {
               sTheme = theme;
               activity.finish();
               activity.startActivity(new Intent(activity, activity.getClass()));
               activity.overridePendingTransition(android.R.anim.fade_in,
                       android.R.anim.fade_out);
           }
            public static void onActivityCreateSetTheme(Activity activity) {
               switch (sTheme) {
                       default:
                           case DAY_MODE:
                               activity.setTheme(R.style.AppTheme);
                              break;
                   case NIGHT_MODE:
                               activity.setTheme(R.style.BlackTheme);
                               break;
               }}

}
