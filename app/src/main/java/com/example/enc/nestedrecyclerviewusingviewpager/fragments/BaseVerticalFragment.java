package com.example.enc.nestedrecyclerviewusingviewpager.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enc.nestedrecyclerviewusingviewpager.HorizontalRecylerAdapter;
import com.example.enc.nestedrecyclerviewusingviewpager.MainRecyclerAdapter;
import com.example.enc.nestedrecyclerviewusingviewpager.R;
import com.example.enc.nestedrecyclerviewusingviewpager.models.RecyclerItemsResponse;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.NestedRecyclerViewUsingViewPagerSDK;
import com.example.enc.nestedrecyclerviewusingviewpager.nestedrecyclerviewusingviewpagersdk.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BaseVerticalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BaseVerticalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseVerticalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView verticalRecyclerView;
    RecyclerView horizontalRecyclerView;
    Service service;


    private OnFragmentInteractionListener mListener;

    public BaseVerticalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaseVerticalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BaseVerticalFragment newInstance(String param1, String param2) {
        BaseVerticalFragment fragment = new BaseVerticalFragment();
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

        View view = inflater.inflate(R.layout.fragment_base_vertical, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        verticalRecyclerView = view.findViewById(R.id.verticalRecyclerView);

        service = NestedRecyclerViewUsingViewPagerSDK.getClient().create(Service.class);

        // vertical recycler view operation
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(getContext());
        verticalRecyclerView.setAdapter(mainRecyclerAdapter);
//
//
//        Call<RecyclerItemsResponse> call = service.retriveVerticalRecyclerDataValues();
//        call.enqueue(new Callback<RecyclerItemsResponse>() {
//            @Override
//            public void onResponse(Call<RecyclerItemsResponse> call, Response<RecyclerItemsResponse> response) {
//
//                MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(getContext(),response.body().getItemLists());
//                verticalRecyclerView.setAdapter(mainRecyclerAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<RecyclerItemsResponse> call, Throwable t) {
//                call.cancel();
//            }
//        });





   /*     // horizontal recycler view operation
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(layoutManager);

        Call<RecyclerItemsResponse> call1 = service.retriveHorizontalRecyclerDataValues();
        call1.enqueue(new Callback<RecyclerItemsResponse>() {
            @Override
            public void onResponse(Call<RecyclerItemsResponse> call, Response<RecyclerItemsResponse> response) {

                HorizontalRecylerAdapter horizontalRecylerAdapter = new HorizontalRecylerAdapter(getActivity(), response.body().getItemLists());
                horizontalRecyclerView.setAdapter(horizontalRecylerAdapter);
            }

            @Override
            public void onFailure(Call<RecyclerItemsResponse> call, Throwable t) {
                call.cancel();
            }
        });


*/












    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}