package com.riddhik.myapps.androiddevtrainingbasics;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

        //ViewGroup layout = (ViewGroup) rootView.findViewById(R.id.fragment_display_message);
        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.fragment_display_message);

        TextView messageText = new TextView(getActivity());
        messageText.setTextSize(40);
        if(message != null && message.length() > 1){
            messageText.setText(message);

            layout.addView(messageText);
        } else {
            //message = getResources().getString(R.string.blank_message);
            //messageText.setText(R.string.blank_message);

            Toast.makeText(getContext(), R.string.blank_message, Toast.LENGTH_SHORT).show();
        }

        TextView deviceInfo = new TextView(getActivity());
        deviceInfo.setText(showDeviceInfo());
        layout.addView(deviceInfo);

        return rootView;
    }

    public String showDeviceInfo(){
        String deviceInfo = "";

        String board = Build.BOARD.toString();
        String bootloader = Build.BOOTLOADER;
        String brand = Build.BRAND;
        String device = Build.DEVICE;
        String model = Build.MODEL;
        String display = Build.DISPLAY;
        String codename = Build.VERSION.CODENAME;

        deviceInfo = "Board: " + board
                + "\n Bootloader: " + bootloader
                + "\n Brand: " + brand
                + "\n Device: " + device
                + "\n Model: " + model
                + "\n Display: " + display
                + "\n Codename: " + codename;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            Toast.makeText(getActivity(), "Version more than Honeycomb", Toast.LENGTH_SHORT).show();
        }
        return deviceInfo;
    }
}
