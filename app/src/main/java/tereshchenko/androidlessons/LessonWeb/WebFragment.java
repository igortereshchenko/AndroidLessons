package tereshchenko.androidlessons.LessonWeb;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

import tereshchenko.androidlessons.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends WebViewFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result= super.onCreateView(inflater, container, savedInstanceState);
        getWebView().getSettings().setJavaScriptEnabled(true);
        // настройка масштабирования
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl("http://stackoverflow.com");
        return(result);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
