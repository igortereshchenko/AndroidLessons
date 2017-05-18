package tereshchenko.androidlessons.LessonFragment;


import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import tereshchenko.androidlessons.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsyncTaskFragment extends Fragment {

    int[] integers=null;
    ProgressBar indicatorBar;
    TextView statusView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_async_task, container, false);


        integers = new int[100];
        for(int i=0;i<100;i++) {
            integers[i] = i + 1;
        }
        indicatorBar = (ProgressBar) view.findViewById(R.id.progressIndicator);
        statusView = (TextView) view.findViewById(R.id.txtStatusView);
        Button btnFetch = (Button)view.findViewById(R.id.btnProgress);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ProgressTask().execute();
            }
        });

        return view;
    }

    //Класс для хранения информации, которая нужна для обработки задачи

    //Тип объектов, которые используются для индикации процесса выполнения задачи

    //Тип результата задачи

    class ProgressTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... unused) {
            for (int i = 0; i<integers.length;i++) {

                publishProgress(i);
                SystemClock.sleep(400);
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... items) {
            indicatorBar.setProgress(items[0]+1);
            statusView.setText("Статус: " + String.valueOf(items[0]+1));
        }
        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(getActivity(), "Задача завершена", Toast.LENGTH_SHORT)
                    .show();
        }
    }





}
