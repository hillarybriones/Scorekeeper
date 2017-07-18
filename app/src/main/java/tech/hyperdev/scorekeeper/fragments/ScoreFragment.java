package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {
private TextView textView;
    private String name;
    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_score, container, false);
        textView=(TextView)v.findViewById(R.id.tvTeamName);
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

}
