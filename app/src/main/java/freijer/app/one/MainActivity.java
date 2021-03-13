package freijer.app.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    ArrayList<RecyclerViewItem> recyclerViewItem;
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewItem = new ArrayList<>();

        makeRecyclerList("Проба");
        makeRecyclerList("Эксперемент");
        makeRecyclerList("Новая проба");
        makeRecyclerList("Тестируем");

            recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setHasFixedSize(true);
            adapter = new RecyclerViewAdapter(recyclerViewItem);
            layoutManager = new LinearLayoutManager(this);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);
    }

    public void makeRecyclerList(String income){
        recyclerViewItem.add(new RecyclerViewItem(R.drawable.star, income));

    }


}



