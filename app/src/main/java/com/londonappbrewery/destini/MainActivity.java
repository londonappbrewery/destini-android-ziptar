package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    protected TextView _StoryTextView;
    protected Button _TopButton;
    protected Button _BottomButton;
    int _StoryIndex = 1;
    enum ClickedButton {Top, Bottom}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        _StoryTextView = (TextView) findViewById(R.id.storyTextView);
        _TopButton = (Button) findViewById(R.id.buttonTop);
        _BottomButton = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null) {
            _StoryIndex = savedInstanceState.getInt("StoryIndex");
            _StoryTextView.setText(savedInstanceState.getCharSequence("StoryText"));
            _TopButton.setText(savedInstanceState.getCharSequence("Answer1"));
            _BottomButton.setText(savedInstanceState.getCharSequence("Answer2"));

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        }

        _TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(ClickedButton.Top, _StoryIndex);

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        _BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(ClickedButton.Bottom, _StoryIndex);
            }
        });
    }

    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex", _StoryIndex);
        outState.putCharSequence("StoryText", _StoryTextView.getText());
        outState.putCharSequence("Answer1", _TopButton.getText());
        outState.putCharSequence("Answer2", _BottomButton.getText());
    }

    private void update(ClickedButton clickedButton,int storyIndex) {
        if (clickedButton == ClickedButton.Top) {
            switch (storyIndex) {
                case 1 : {
                    _StoryTextView.setText(R.string.T3_Story);
                    _TopButton.setText(R.string.T3_Ans1);
                    _BottomButton.setText(R.string.T3_Ans2);
                    break;
                }
                case 2 : {
                    if (_StoryTextView.getText() == getResources().getString(R.string.T3_Story)){
                        _StoryTextView.setText(R.string.T6_End);
                        _TopButton.setVisibility(View.INVISIBLE);
                        _BottomButton.setVisibility(View.INVISIBLE);
                    }
                    else if (_StoryTextView.getText() == getResources().getString(R.string.T2_Story)) {
                        _StoryTextView.setText(R.string.T3_Story);
                        _TopButton.setText(R.string.T3_Ans1);
                        _BottomButton.setText(R.string.T3_Ans2);
                    }
                    break;
                }
                case 3 : {
                    _StoryTextView.setText(R.string.T6_End);
                    _TopButton.setVisibility(View.INVISIBLE);
                    _BottomButton.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        } else {
            switch (storyIndex) {
                case 1 : {
                    _StoryTextView.setText(R.string.T2_Story);
                    _TopButton.setText(R.string.T2_Ans1);
                    _BottomButton.setText(R.string.T2_Ans2);
                    break;
                }
                case 2 : {
                    if (_StoryTextView.getText() == getResources().getString(R.string.T3_Story)){
                        _StoryTextView.setText(R.string.T5_End);
                        _TopButton.setVisibility(View.INVISIBLE);
                        _BottomButton.setVisibility(View.INVISIBLE);
                    }
                    else if (_StoryTextView.getText() == getResources().getString(R.string.T2_Story)) {
                        _StoryTextView.setText(R.string.T4_End);
                        _TopButton.setVisibility(View.INVISIBLE);
                        _BottomButton.setVisibility(View.INVISIBLE);
                    }
                    break;
                }
                case 3 : {
                    _StoryTextView.setText(R.string.T5_End);
                    _TopButton.setVisibility(View.INVISIBLE);
                    _BottomButton.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        }

        _StoryIndex = (_StoryIndex % 3) + 1;

    }
}
