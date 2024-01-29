package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shop.R;
import com.example.shop.Shoes;
import com.example.shop.categoryModal;
import com.example.shop.fashion;

import java.util.ArrayList;

import Adapter.RecycleCatgeoryAdapter;


public class CategoryFragment extends Fragment {

    CardView fashion , mobiles ,shoes;

    ArrayList<categoryModal> arrCategories = new ArrayList<>();
    RecyclerView recyclerView ;

    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        fashion = view.findViewById(R.id.fashions);
        mobiles = view.findViewById(R.id.mobiles);
        shoes = view.findViewById(R.id.shoes);

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), com.example.shop.fashion.class);
                startActivity(inext);
            }
        });
        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), com.example.shop.Mobiles.class);
                startActivity(inext);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext ;
                inext = new Intent(getActivity(), Shoes.class);
                startActivity(inext);
            }
        });
        return view;
    }
}