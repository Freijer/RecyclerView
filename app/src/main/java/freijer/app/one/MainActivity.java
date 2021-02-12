package freijer.app.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected int asd;

    protected int plusLength; //+1 буква в слове
    private int stayLength; //слова той же длинны подряд раз
    private int minusLength; //-1 буква в слове
    protected  ArrayList<String> Alfas = new ArrayList<>(); //вхоящий прогресс







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



