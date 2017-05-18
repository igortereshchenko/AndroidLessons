package tereshchenko.androidlessons.LessonLists.LessonGrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import tereshchenko.androidlessons.R;

public class LessonGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_grid);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        final ImageView img = (ImageView)findViewById(R.id.imageSingleView);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.GONE);
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity

                int resource = ImageAdapter.mThumbIds[position];


                img.setImageResource(resource);
                img.setVisibility(View.VISIBLE);
            }
        });
    }
}
