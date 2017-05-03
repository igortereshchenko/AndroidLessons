package tereshchenko.androidlessons.LessonResources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

public class ResourceLesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_lesson);
    }

    public void btnAuthor(View sender){

        TextView txtAuthor =(TextView)findViewById(R.id.txtAuthor);

        //string resource
        String author = getResources().getString(R.string.author);

        //dimension resource
        int leftPadding = (int)getResources().getDimension(R.dimen.horizontal_margin);
        int topPadding = (int)getResources().getDimension(R.dimen.vertical_margin);

        txtAuthor.setPadding(leftPadding,topPadding,leftPadding,topPadding);

        //color resource
        int backgroundColor = ContextCompat.getColor(this, R.color.textViewColor);


        txtAuthor.setBackgroundColor(backgroundColor);

        txtAuthor.setText(author);

    }

}
