package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Click(View v){
        EditText wordEl = findViewById(R.id.Word1);

        String word = wordEl.getText().toString();
        String ignored = "1234567890";
        String resultWord = convertWord(word, ignored);

        TextView viewEl = findViewById(R.id.View1);
        viewEl.setText(resultWord);
    }

    public static String convertWord(String s, String ig){
        String result = "";
        List ignored = Arrays.asList(ig.split(""));
        String[] words = s.split(" ");

        for (String word : words) {

            String[] arr = word.split("");

            int a = arr. length - 1;
            for(int b = 0; b < a; ){

                if(ignored.contains(arr[b]) || ignored.contains(arr[a])){
                    if(ignored.contains(arr[b])){
                        b++;
                    }if(ignored.contains(arr[a])){
                        a--;
                    }
                }

                if(!ignored.contains(arr[b])){
                    if(!ignored.contains(arr[a])){
                        String tmp = arr[b];
                        arr[b] = arr[a];
                        arr[a] = tmp;
                        b++;
                        a--;
                    }
                }

            }
            String resultWord = "";
            for(String letter : arr){
                resultWord = resultWord + letter;
            }

            result = result + " " + resultWord;
        }

        return result;
    }
}