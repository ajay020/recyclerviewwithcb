package com.example.ajay.paytmintegration;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.ajay.paytmintegration.Interface.OnViewClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private MyAdapter adapter;
    private StringBuffer stringBuffer = null;
    private RecyclerView recyclerView;
    public ArrayList<Player> checkedPlayers = new ArrayList<>();
    ArrayList<Player> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(this,getPlayers());
        fab = findViewById(R.id.fb_floating_button);
        recyclerView = findViewById(R.id.rv_checkbox);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setViewListener(new OnViewClickListener() {
            @Override
            public void onViewClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Clicked on position "+position, Toast.LENGTH_SHORT).show();

                CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_checkbox);
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                    players.get(position).setChecked(false);
                    checkedPlayers.remove(players.get(position));
                    view.setBackgroundColor(Color.WHITE);
                } else {
                    checkedPlayers.add(players.get(position));
                    players.get(position).setChecked(true);
                   checkBox.setChecked(true);
                   view.setBackgroundColor(Color.GRAY);
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuffer = new StringBuffer();

                for (Player p : checkedPlayers) {

                    stringBuffer.append(p.getName()).append("\n");
                }

                if (checkedPlayers.size() > 0) {
                    Toast.makeText(MainActivity.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Select Players", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private ArrayList<Player> getPlayers() {
        players =new ArrayList<>();

        for (int i=0; i<10; i++) {

            Player player = new Player("Messy"+i,"striker"+i,R.drawable.ic_launcher_background);
            players.add(player);
        }

        return players;
    }
}
