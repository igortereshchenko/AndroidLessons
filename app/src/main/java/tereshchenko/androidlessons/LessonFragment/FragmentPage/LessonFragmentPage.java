package tereshchenko.androidlessons.LessonFragment.FragmentPage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tereshchenko.androidlessons.R;

public class LessonFragmentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fragment_page);

        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }
}
