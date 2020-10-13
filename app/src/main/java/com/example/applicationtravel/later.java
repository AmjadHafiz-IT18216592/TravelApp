package com.example.applicationtravel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link later#newInstance} factory method to
 * create an instance of this fragment.
 */
public class later extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public later() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment later.
     */
    // TODO: Rename and change types and number of parameters
    public static later newInstance(String param1, String param2) {
        later fragment = new later();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_later, container, false);
        TextView textView = view.findViewById(R.id.text_view);
        String sTitle = getArguments().getString("title");
        textView.setText(sTitle);
        //My one
        TextView datex =(TextView) view.findViewById(R.id.text_view3);
        TextView placex=(TextView) view.findViewById(R.id.text_view);
        TextView update =(TextView) view.findViewById(R.id.text_view5);
        placex.setText(weatherForm.global_place);
        datex.setText(weatherForm.global_date);

        String currentDate = new SimpleDateFormat("MMM dd yyyy ", Locale.getDefault()).format(new Date());
        String currentDatet = new SimpleDateFormat("MMM dd yyyy hh:mm:ss a", Locale.getDefault()).format(new Date());
        datex.setText(currentDate);
        update.setText(currentDatet);
        return view;
    }
}