package tereshchenko.androidlessons.LessonFragment.FragmentPage;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by Igor on 5/22/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager mgr) {
        super(mgr);
    }
    @Override
    public int getCount() {
        return(10);
    }
    @Override
    public Fragment getItem(int position) {
        return(FragmentFirstPage.newInstance(position));
    }
}