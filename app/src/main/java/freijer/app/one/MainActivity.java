package freijer.app.one;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    protected int plusLength; //+1 буква в слове
    private int stayLength; //слова той же длинны подряд раз
    private int minusLength; //-1 буква в слове
    protected  ArrayList<String> Alfas = new ArrayList<>(); //вхоящий прогресс
    protected  ArrayList<String> Buffer = new ArrayList<>(); //вхоящий прогресс

    protected int count_word_plus;
    protected int count_word_stay;
    protected int count_word_minus;



    protected int simbol_lenght;
    protected int count_simbol_up;

    public int getSimbol_lenght() {
        return simbol_lenght;
    }
    public void setSimbol_lenght(int simbol_lenght) {
        this.simbol_lenght = simbol_lenght;
    }
    public int getCount_simbol_up() {
        return count_simbol_up;
    }
    public void setCount_simbol_up(int count_simbol_up) {
        this.count_simbol_up = count_simbol_up;
    }



    public int getCount_word_plus() {
        return count_word_plus;
    }
    public void setCount_word_plus(int count_word_plus) {
        this.count_word_plus = count_word_plus;
    }
    public int getCount_word_stay() {
        return count_word_stay;
    }
    public void setCount_word_stay(int count_word_stay) {
        this.count_word_stay = count_word_stay;
    }
    public int getCount_word_minus() {
        return count_word_minus;
    }
    public void setCount_word_minus(int count_word_minus) {
        this.count_word_minus = count_word_minus;
    }

    TextView count_plus, count_stay, count_minus, max_plus;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Alfas.add("т");
//        Alfas.add("то");
//        Alfas.add("тор");
//        Alfas.add("торт");
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
        count_stay = findViewById(R.id.count_stay);
        count_minus = findViewById(R.id.count_minus);
        max_plus = findViewById(R.id.max_plus);


        setCount_word_plus(plusLength);


        counterUo(plusLength);
    }

//    protected void counterUo(int income){
//        if (income >2) {
//            for(int i=0; i<2; i++) {
//                Buffer.add("" + income);
//            }
//        }
//        Log.d("test_-po", "размер: " + (Buffer.size()));
//    }

    protected void counterUo(int income){
        if (income >2) {
            count_simbol_up++;
        }
        Log.d("test_-po", "размер: " + (count_simbol_up));
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



