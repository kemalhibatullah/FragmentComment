package com.example.fragmentcomment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class CommentFragment extends Fragment {

    private static final String COMMENT = "comment";
    // untuk menampung inputan dari edit tex
    private String comment;

    private OnFragmentInteractionListener mListener;

    public CommentFragment() {
        // Required empty public constructor
    }

    public static CommentFragment newInstance(String comment) {
        CommentFragment fragment = new CommentFragment();
        Bundle args = new Bundle();
        args.putString(COMMENT, comment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // untuk membuat view dan memanggil layout fragment
        final View rootView = inflater.inflate(R.layout.fragment_comment, container, false);
        // untuk memanggil atribut yang ada di layout fragment
        final TextView textView = rootView.findViewById(R.id.title_comment);
        final EditText editKomen = rootView.findViewById(R.id.comment_field);

        // untuk mengecek argumen
        if (getArguments().containsKey(COMMENT)){
            comment = getArguments().getString(COMMENT);
            editKomen.setText(comment);
        }

        editKomen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mListener.onInputComment(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootView;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void onInputComment(String comment);
    }
}
