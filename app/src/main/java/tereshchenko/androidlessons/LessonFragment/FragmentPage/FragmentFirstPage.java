package tereshchenko.androidlessons.LessonFragment.FragmentPage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tereshchenko.androidlessons.R;


public class FragmentFirstPage extends Fragment {
    private int pageNumber;

    public static FragmentFirstPage newInstance(int page) {
        FragmentFirstPage fragment = new FragmentFirstPage();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentFirstPage() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_first_page, container, false);
        TextView pageHeader=(TextView)result.findViewById(R.id.displayText);
        String header = String.format("Фрагмент %d", pageNumber+1);
        pageHeader.setText(header);
        return result;
    }
}
