package tereshchenko.androidlessons.LessonControls;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tereshchenko.androidlessons.R;

public class SnackbarControl extends AppCompatActivity {

    private View coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lesson_controls_snackbar);


        coordinatorLayout = findViewById(R.id.coordinatorLayout);

    }




    public void btnSimpleSnackbar(View view) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Простой Snackbar", Snackbar.LENGTH_LONG);
        snackbar.show();
    }



    public void btnSnackbarActionCallback(View view) {
        Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Сообщение удалено", Snackbar.LENGTH_LONG)
                        .setAction("Отмена", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Действие отменено!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
        snackbar.show();
    }



    public void btnSnackbarCustomView(View view) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Нет интернет соединения!", Snackbar.LENGTH_LONG)
                        .setAction("Повторить", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);

        snackbar.show();
    }


}
