package tech.hyperdev.scorekeeper.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment fragmentA,fragmentB;
    //private ScoreFragment objA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA=ScoreFragment.newInstance("Team 1");
        fragmentB=ScoreFragment.newInstance("Team 2");



        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment1,fragmentA)
                                          .replace(R.id.fragment2,fragmentB)
                .commit();

    }
}
