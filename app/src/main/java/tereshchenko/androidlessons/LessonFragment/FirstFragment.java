package tereshchenko.androidlessons.LessonFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tereshchenko.androidlessons.R;


public class FirstFragment extends Fragment {

    private OnFirstFragmentListener mListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View me = inflater.inflate(R.layout.fragment_first, container, false);

        me.findViewById(R.id.btnSentToSecondFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotifySecondFragment(me);
            }
        });

        return me;
    }



    private void NotifySecondFragment(View me){

        EditText edit = (EditText)me.findViewById(R.id.editFirstEdit);

        if (mListener != null) {
            mListener.onFirstFragment(edit.getText().toString(),this);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentListener) {
            mListener = (OnFirstFragmentListener) context;
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


    public interface OnFirstFragmentListener {
        // TODO: Update argument type and name
        void onFirstFragment(String info,Fragment sender);
    }
}
