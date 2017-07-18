package tech.hyperdev.scorekeeper.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {
private TextView textView;
    private String name;
    private ImageButton plus,minus;
    private int clickcount=0;
    private TextView score;
    private String param1="key1";

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_score, container, false);
        textView=(TextView)v.findViewById(R.id.tvTeamName);
        plus=(ImageButton)v.findViewById(R.id.btnPlus);
        minus=(ImageButton)v.findViewById(R.id.btnMinus);
        score=(TextView)v.findViewById(R.id.textView2);

        if(savedInstanceState!=null){
            clickcount = savedInstanceState.getInt("textView2",0);
            score.setText(String.valueOf(clickcount));
        }
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount++;
                score.setText(String.valueOf(clickcount));
            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount--;
                score.setText(String.valueOf(clickcount));
            }
        });
        readBundle(getArguments());
        textView.setText(name);
        return v;

    }
public static  ScoreFragment newInstance(String name ){
    Bundle bundle =new Bundle();
    bundle.putString("name",name);
    ScoreFragment fragment=new ScoreFragment();
    fragment.setArguments(bundle);
    return fragment;
}
    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            name = bundle.getString("name");

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("textView2",clickcount);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
