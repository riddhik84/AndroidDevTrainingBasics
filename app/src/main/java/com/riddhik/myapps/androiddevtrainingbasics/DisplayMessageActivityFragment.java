package com.riddhik.myapps.androiddevtrainingbasics;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class DisplayMessageActivityFragment extends Fragment {

    static String LOG_TAG = DisplayMessageActivityFragment.class.getSimpleName();

    public DisplayMessageActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_display_message, container, false);

        Intent intent = getActivity().getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d(LOG_TAG, "Received Message : " +message);

        TextView messageText = new TextView(getActivity());
        messageText.setTextSize(40);
        if(message != null){
            messageText.setText(message);

            RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.fragment_display_message);
            layout.addView(messageText);
        } else {
            Toast.makeText(getContext(), "No message received", Toast.LENGTH_SHORT).show();
        }

        return rootView;
    }
}
