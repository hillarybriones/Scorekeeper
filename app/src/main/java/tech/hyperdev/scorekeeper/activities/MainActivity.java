package tech.hyperdev.scorekeeper.activities;


import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment fragmentA, fragmentB;
    private ImageButton plus, minus;
    private int clickcount = 0;
    private TextView score;
    private Spinner spThemes;

    //private ScoreFragment objA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);


        fragmentA = ScoreFragment.newInstance("Team 1");
        fragmentB = ScoreFragment.newInstance("Team 2");


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment1, fragmentA)
                .replace(R.id.fragment2, fragmentB)
                .commit();
        if(savedInstanceState==null);
        fragmentA = ScoreFragment.newInstance("Team 1");
        fragmentB = ScoreFragment.newInstance("Team 2");

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment1, fragmentA)
                .replace(R.id.fragment2, fragmentB)
                .commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mode_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dayTheme:
                Utils.changeToTheme(this,0);
                Toast.makeText(this,"Day mode", Toast.LENGTH_SHORT).show();
                               break;
            case R.id.nightTheme:
                               Utils.changeToTheme(this,1);
                               Toast.makeText(this,"Night Mode", Toast.LENGTH_SHORT).show();
                               break;
            }

                      return super.onOptionsItemSelected(item);


    }
}
