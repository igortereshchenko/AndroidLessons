package tereshchenko.androidlessons.LessonWeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import tereshchenko.androidlessons.R;

public class LessonWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_web);

        WebView browser=(WebView)findViewById(R.id.webBrowser);

        browser.getSettings().setJavaScriptEnabled(true);
        // настройка масштабирования
        browser.getSettings().setSupportZoom(true);
        browser.getSettings().setBuiltInZoomControls(true);

        browser.loadUrl("http://stackoverflow.com");
    }
}
