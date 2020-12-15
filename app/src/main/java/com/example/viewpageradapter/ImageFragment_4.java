package com.example.viewpageradapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment_4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment_4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = ImageFragment_4.class.getSimpleName();
    private static final String ARG_INDEX = "ARG_INDEX";
    private static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";

    private int mPosition;
    private int mImageResourceId;

    private OnPageClickListener mListener;

    public ImageFragment_4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position page index
     * @param imagesResourceIds image resource id
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment_4 newInstance(int position, int imagesResourceIds) {
        ImageFragment_4 fragment = new ImageFragment_4();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, position);
        args.putInt(ARG_IMAGE_ID, imagesResourceIds);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_INDEX);
            mImageResourceId = getArguments().getInt(ARG_IMAGE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(mImageResourceId);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onImagePressed(mPosition);
            }
        });
    }

    public void onImagePressed(int index){
        if (mListener != null){
            mListener.onPageClick(index);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPageClickListener ){
            mListener = (OnPageClickListener) context;
        }else {
            throw new RuntimeException(context.toString()+
                    "must implement OnPageClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}