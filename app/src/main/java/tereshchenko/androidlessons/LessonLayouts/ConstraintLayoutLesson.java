package tereshchenko.androidlessons.LessonLayouts;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.R;

public class ConstraintLayoutLesson extends Lesson {


    @Override
    public View btnLessonOpen(View sender) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lesson_layouts_constraint_layout, null, false);

        return layout;

    }

    @Override
    public View btnLessonCodeOpen(View sender) {



        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        constraintLayout.setMinimumHeight(300);
        constraintLayout.setMinimumWidth(300);

        constraintLayout.setId(1000);


        TextView contactUs = new TextView(this);
        contactUs.setText("Контакты");
        contactUs.setTextSize(25);
        contactUs.setId(1);

        ConstraintLayout.LayoutParams clpcontactUs = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        contactUs.setLayoutParams(clpcontactUs);

        constraintLayout.addView(contactUs);


        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        // show text in center
        constraintSet.connect(contactUs.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP, 18);
        constraintSet.connect(contactUs.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 18);

        constraintSet.connect(contactUs.getId(), ConstraintSet.BOTTOM, constraintLayout.getId(), ConstraintSet.BOTTOM, 18);
        constraintSet.connect(contactUs.getId(), ConstraintSet.RIGHT, constraintLayout.getId(), ConstraintSet.RIGHT, 18);

        constraintSet.applyTo(constraintLayout);



        // Baseline Alignment

        TextView senderNameL = new TextView(this);
        senderNameL.setId(2);
        senderNameL.setText("Введите текст: ");
        senderNameL.setTextSize(20);

        constraintLayout.addView(senderNameL);

        EditText senderName = new EditText(this);
        senderName.setId(3);
        constraintLayout.addView(senderName);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);


        constraintSet.connect(senderNameL.getId(), ConstraintSet.TOP, contactUs.getId(), ConstraintSet.BOTTOM, 8);
        constraintSet.connect(senderNameL.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 8);

        constraintSet.connect(senderName.getId(), ConstraintSet.LEFT, senderNameL.getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(senderName.getId(), ConstraintSet.RIGHT, constraintLayout.getId(), ConstraintSet.RIGHT, 8);

        constraintSet.connect(senderName.getId(), ConstraintSet.BASELINE, senderNameL.getId(), ConstraintSet.BASELINE, 0);


        //Adding View Size Constraint in Code
        constraintSet.constrainWidth(senderName.getId(), ConstraintSet.MATCH_CONSTRAINT);




        constraintSet.applyTo(constraintLayout);

        return constraintLayout;


    }
}
