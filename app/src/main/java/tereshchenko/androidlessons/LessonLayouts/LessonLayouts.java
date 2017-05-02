package tereshchenko.androidlessons.LessonLayouts;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import tereshchenko.androidlessons.Lesson;
import tereshchenko.androidlessons.LessonControls.TextViewControl;
import tereshchenko.androidlessons.MainActivity;
import tereshchenko.androidlessons.R;

/**
 * Created by Igor on 4/29/2017.
 */

public class LessonLayouts  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lesson_layouts);
    }



    public void btnLinearLayout(View sender){

        Intent intent = new Intent(this, LinearLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"LinearLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Контейнер LinearLayout представляет объект ViewGroup, который упорядочивает все дочерние элементы в одном направлении: по горизонтали или по вертикали.");

        startActivity(intent);

    }


    public void btnRelativeLayout(View sender){

        Intent intent = new Intent(this, RelativeLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"RelativeLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"RelativeLayout представляет объект ViewGroup, который располагает дочерние элементы относительно позиции других дочерних элементов разметки или относительно области самой разметки RelativeLayout. Используя относительное позиционирование, мы можем установить элемент по правому краю или в центре или иным способом, который предоставляет данный контейнер.");

        startActivity(intent);

    }

    public void btnTableLayout(View sender){

        Intent intent = new Intent(this, TableLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"TableLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Контейнер TableLayout структурирует элементы управления по столбцам и строкам.");

        startActivity(intent);

    }


    public void btnFrameLayout(View sender){

        Intent intent = new Intent(this, FrameLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"FrameLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Контейнер FrameLayout предназначен для вывода на экран одного помещенного в него визуального элемента. Если же мы поместим несколько элементов, то они будут накладываться друг на друга.");

        startActivity(intent);

    }

    public void btnGridLayout(View sender){

        Intent intent = new Intent(this, GridLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"GridLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"GridLayout представляет еще один контейнер, который позволяет создавать табличные представления. GridLayout состоит из коллекции строк, каждая из которых состоит из отдельных ячеек.");

        startActivity(intent);

    }

    public void btnScrollView(View sender){

        Intent intent = new Intent(this, ScrollViewLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"ScrollView");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"Контейнер ScrollView предназначен для создания прокрутки для такого интерфейса, все элементы которого одномоментно не могут поместиться на экране устройства. ScrollView может вмещать только один элемент, поэтому если мы хотим разместить несколько элементов, то их надо поместить в какой-нибудь контейнер.");

        startActivity(intent);

    }

    public void btnConstraintLayout(View sender){

        Intent intent = new Intent(this, ConstraintLayoutLesson.class);
        intent.putExtra(Lesson.LESSON_NAME,"ConstraintLayout");
        intent.putExtra(Lesson.LESSON_DESCRIPTION,"ConstraintLayout представляет новый тип контейнеров, который является развитием RelativeLayout и позволяет создавать гибкие и масштабируемые интерфейсы.");

        startActivity(intent);

    }
}