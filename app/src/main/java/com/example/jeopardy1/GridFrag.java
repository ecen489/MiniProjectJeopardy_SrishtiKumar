package com.example.jeopardy1;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridFrag extends Fragment {

    private static final int REQ_CODE_ANS = 2468;
    int totalScore = 0;
    ArrayList<Button> buttonArrayList = new ArrayList<>();

    public GridFrag() {
        // Required empty public constructor
    }

    public void getQuestionSelected() {

        for(Button btn : buttonArrayList) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = getView().findViewById(v.getId());
                    int questionValue = Integer.parseInt(b.getText().toString());
                    Intent forwardIntent = new Intent(getActivity(), QuestionActivity.class);
                    forwardIntent.putExtra("questionValue", questionValue);
                    startActivityForResult(forwardIntent,REQ_CODE_ANS);
                    b.setEnabled(false);
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_grid, container, false);

        return myView;
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        createList();
        getQuestionSelected();

    }

//    BackIntent returns control back here
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == REQ_CODE_ANS)
        {
            String userAns = intent.getStringExtra("Answer");
            int score = intent.getIntExtra("questionValue", 0);
            if(userAns.equalsIgnoreCase("1"))
            {
                totalScore += score;
                Fragment frag = (Fragment) getFragmentManager().findFragmentById((R.id.frag_main1));
                TextView textView = ((TextView) frag.getView().findViewById(R.id.scoreboard));
                textView.setText(Integer.toString(totalScore));

                Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putInt("totalScore" , totalScore);
    }

    public void createList()
    {
        final Button button1 = (Button) getView().findViewById(R.id.button1);
        final Button button2 = (Button) getView().findViewById(R.id.button2);
        final Button button3 = (Button) getView().findViewById(R.id.button3);
        final Button button4 = (Button) getView().findViewById(R.id.button4);
        final Button button5 = (Button) getView().findViewById(R.id.button5);
        final Button button6 = (Button) getView().findViewById(R.id.button6);
        final Button button7 = (Button) getView().findViewById(R.id.button7);
        final Button button8 = (Button) getView().findViewById(R.id.button8);
        final Button button9 = (Button) getView().findViewById(R.id.button9);
        final Button button10 = (Button) getView().findViewById(R.id.button10);
        final Button button11 = (Button) getView().findViewById(R.id.button11);
        final Button button12 = (Button) getView().findViewById(R.id.button12);
        final Button button13 = (Button) getView().findViewById(R.id.button13);
        final Button button14 = (Button) getView().findViewById(R.id.button14);
        final Button button15 = (Button) getView().findViewById(R.id.button15);
        final Button button16 = (Button) getView().findViewById(R.id.button16);
        final Button button17 = (Button) getView().findViewById(R.id.button17);
        final Button button18 = (Button) getView().findViewById(R.id.button18);
        final Button button19 = (Button) getView().findViewById(R.id.button19);
        final Button button20 = (Button) getView().findViewById(R.id.button20);
        buttonArrayList.add(button1);
        buttonArrayList.add(button2);
        buttonArrayList.add(button3);
        buttonArrayList.add(button4);
        buttonArrayList.add(button5);
        buttonArrayList.add(button6);
        buttonArrayList.add(button7);
        buttonArrayList.add(button8);
        buttonArrayList.add(button9);
        buttonArrayList.add(button10);
        buttonArrayList.add(button11);
        buttonArrayList.add(button12);
        buttonArrayList.add(button13);
        buttonArrayList.add(button14);
        buttonArrayList.add(button15);
        buttonArrayList.add(button16);
        buttonArrayList.add(button17);
        buttonArrayList.add(button18);
        buttonArrayList.add(button19);
        buttonArrayList.add(button20);
    }

}
