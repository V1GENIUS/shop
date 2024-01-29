package Fragments;

import static android.app.ProgressDialog.show;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shop.AppNotification;
import com.example.shop.FilterFragment;
import com.example.shop.R;
import com.example.shop.Shoes;

import java.util.ArrayList;

import FilterFragments.CategoriesFragment;
import FilterFragments.ColorsFragment;
import FilterFragments.DeliveryFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    ImageView AppNotification;
    Button frag1 , frag2 , frag3 , btn_filter;


    AutoCompleteTextView searchbar;
    ArrayList<String> arr_search = new ArrayList<String>();





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AppNotification = view.findViewById(R.id.notification);
        btn_filter = view.findViewById(R.id.filter);


        AppNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), com.example.shop.AppNotification.class);
                startActivity(inext);
            }
        });

        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), FilterFragment.class);
                startActivity(inext);
            }
        });

        try {
            View frag1 = view.findViewById(R.id.frag1);
            frag2 = view.findViewById(R.id.frag2);
            frag3 = view.findViewById(R.id.frag3);
            frag1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)

                {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, new DeliveryFragment());
                    ft.commit();
                }
            });

            frag2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)

                {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, new ColorsFragment());
                    ft.commit();
                }
            });

            frag3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)

                {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.container, new CategoriesFragment());
                    ft.commit();
                }
            });


        } catch (NullPointerException e) {
            //Log.e("HomeFragment", "Error finding view: " + e.getMessage());
            Toast.makeText(getActivity(), "Filter error", Toast.LENGTH_SHORT).show();

            // Handle the error, e.g., display a toast message to the user
        }
        return view ;
    }
}