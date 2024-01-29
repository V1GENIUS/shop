package Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shop.Languages;
import com.example.shop.MyProfile;
import com.example.shop.Notification;
import com.example.shop.R;
import com.example.shop.SaveForLater;
import com.example.shop.login_user;
import com.example.shop.my_orders;

public class profileFragment extends Fragment {

    Button btn_order , btn_review , btn_notification , btn_language , btn_saveForLater , btn_myProfile;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_order = view.findViewById(R.id.order);
        btn_review = view.findViewById(R.id.reviews);
        btn_notification = view.findViewById(R.id.notification);
        btn_language = view.findViewById(R.id.language);
        btn_saveForLater    = view.findViewById(R.id.SaveForLater);
        btn_myProfile = view.findViewById(R.id.my_profile);


        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), my_orders.class);
                startActivity(inext);
            }
        });

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), login_user.class);
                startActivity(inext);
            }
        });

        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), Notification.class);
                startActivity(inext);
            }
        });

        btn_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), Languages.class);
                startActivity(inext);
            }
        });

        btn_saveForLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), SaveForLater.class);
                startActivity(inext);
            }
        });

        btn_myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), MyProfile.class);
                startActivity(inext);
            }
        });
        return view ;
    }
}