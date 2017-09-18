package com.i053113.asyntacksjuan;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    TextView mtex;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtex=(TextView)findViewById(R.id.mtex);
        miAsyncTas mAsinct = new miAsyncTas();
        mAsinct.execute(30);




    }

    class miAsyncTas extends AsyncTask<Integer,Integer,String>

    {


        @Override
        protected String doInBackground(Integer... params) {


            int maximo = params[0];
            for (int i = 4 ; i<= maximo; i ++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return "Fin del conteo JJfR";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int contador = values[0];
            String text=  "Comienza el conteo JJf" + contador;
            mtex.setText(text);
            mtex.setTextSize(contador);
        }

        @Override
        protected void onPostExecute(String s) {
            mtex.append(""+s);
        }




    }
}
