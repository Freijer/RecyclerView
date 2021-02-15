package freijer.app.one;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    static int counter_plus = 0;
    static int plusLenght = 0;
        static int counter_stay = 0;
        static int stayLenght = 0;




    protected int plusLength; //+1 буква в слове
    private int stayLength; //слова той же длинны подряд раз
    private int minusLength; //-1 буква в слове
    protected  ArrayList<String> Alfas = new ArrayList<>(); //вхоящий прогресс



    TextView count_plus, max_plus, max_stay;
    Button pressMe;
    EditText inText_plus, inText_stay;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Alfas.add("т");
        Alfas.add("то");
        Alfas.add("тор");
        Alfas.add("торт");
        Alfas.add("торти");
        Alfas.add("тортик");
        Alfas.add("тортики");
        Alfas.add("тортикищ");
        Alfas.add("тортикища");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикищаз");
        Alfas.add("тортикища");
        Alfas.add("тортикищ");
        Alfas.add("тортики");
        Alfas.add("тортик");
        Alfas.add("торти");
        Alfas.add("торт");
        Alfas.add("тор");
        Alfas.add("то");

            CountCorrectSeqLen(Alfas);
            Log.d("test_+1", "плюс 1 буква: "+plusLength);
                countStayWord(Alfas);
                Log.d("test_stay", "равное кол-во букв: "+stayLength);
                    countWordMinus(Alfas);
                    Log.d("test_-1", "уменьшение на 1 букву: "+minusLength);



        count_plus = findViewById(R.id.count_plus);
        max_plus = findViewById(R.id.max_plus);
        max_stay = findViewById(R.id.max_stay);

        pressMe = findViewById(R.id.pressMe);
        inText_plus = findViewById(R.id.inText_plus);
        inText_stay = findViewById(R.id.inText_stay);


        max_plus.setText(""+counter_plus);
        max_stay.setText(""+counter_stay);

    }


    public void kliker(View v){
        int noteYeat_stay = 5;
        String take_plus = inText_plus.getText().toString();
        String take_stay = inText_stay.getText().toString();
        int in = Integer.parseInt(take_plus);
        add_plus(in);
        max_plus.setText(""+counter_plus);
            int in_stay = Integer.parseInt(take_stay);
            add_stay(in_stay, noteYeat_stay);
            max_stay.setText(""+counter_stay);


    }


    private void add_plus (int input) {
        if (input > 2) {
            counter_plus++;
        }
        plusLenght = input;
    }

    private void add_stay (int input, int param) {
        if (input == param) {
            counter_stay++;
        }
        stayLenght = input;
    }




    public int CountCorrectSeqLen(List<String> data) {
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() + 1) {
                currentLength++;
            } else {
                plusLength = Math.max(plusLength, currentLength);
                currentLength = 1;
            }
        }
        plusLength = Math.max(plusLength, currentLength);
        return plusLength;
    }  // последовательность +1 буква к следующему слову
    public int countStayWord(List<String> data) {
        int currentLength = data.size() != 0 ? 0 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length()) {
                currentLength++;
            } else {
                stayLength = Math.max(stayLength, currentLength);
                currentLength = 0;
            }
        }
        stayLength = Math.max(stayLength, currentLength);
        return stayLength;
    }// слов одинаковой длинны подряд.
    public int countWordMinus(List<String> data) {
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() - 1) {
                currentLength++;
            } else {
                minusLength = Math.max(minusLength, currentLength);
                currentLength = 1;
            }
        }
        minusLength = Math.max(minusLength, currentLength);
        return minusLength;
    }// слов одинаковой длинны уменьшение






}



