package comtoye.udacity.ef.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import comtoye.udacity.ef.myapplication.R;

public class OneFragment extends Fragment {
    private EditText textView1;
    private EditText textView2;
    private Button button;
    String name1;
    String name2;

    private OnFragmentInteractionListener mListener;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView1 = (EditText)view.findViewById(R.id.editText);
        textView2 = (EditText)view.findViewById(R.id.editText2);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = textView1.getText().toString().trim();
                name2 = textView2.getText().toString().trim();
                if(name1 == null || name2 == null){
                    Toast.makeText(getActivity(), "null required", Toast.LENGTH_SHORT).show();
                }else {
                    mListener.onFragmentInteraction(name1, name2);
                    textView1.setText("");
                    textView2.setText("");
                }
            }
        });
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
        void onFragmentInteraction(String name1, String name2);
    }
}
