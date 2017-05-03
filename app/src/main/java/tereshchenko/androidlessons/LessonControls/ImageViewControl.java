package tereshchenko.androidlessons.LessonControls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class ImageViewControl extends Lesson {



    @Override
    public View btnLessonOpen(View sender){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_controls_image_view, null, false);

        return layout;

    }

    @Override
    public View  btnLessonCodeOpen(View sender){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //--------------------------------------------------------

        ImageView imageView = new ImageView(this);
        // применяем ресурс
        imageView.setImageResource(R.drawable.mini);

        linearLayout.addView(imageView);

        return linearLayout;


    }
}