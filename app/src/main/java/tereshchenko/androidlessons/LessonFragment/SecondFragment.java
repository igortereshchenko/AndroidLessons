package tereshchenko.androidlessons.LessonFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import tereshchenko.androidlessons.R;


public class SecondFragment extends Fragment {

    private OnSecondFragmentListener mListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View me = inflater.inflate(R.layout.fragment_second, container, false);

        me.findViewById(R.id.btnSentToFirstFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotifyFirstFragment(me);
            }
        });

        return me;
    }

    private void NotifyFirstFragment(View me){

        EditText edit = (EditText)me.findViewById(R.id.editSecondEdit);

        if (mListener != null) {
            mListener.onSecondFragment(edit.getText().toString());
        }



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecondFragmentListener) {
            mListener = (OnSecondFragmentListener) context;
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

    public interface OnSecondFragmentListener {
        // TODO: Update argument type and name
        void onSecondFragment(String info);
    }





}
