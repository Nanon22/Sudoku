package fr.nanon.universjavamobile.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

import fr.nanon.universjavamobile.sudoku.customui.Box;
import fr.nanon.universjavamobile.sudoku.sudoku.Sudoku;
import fr.nanon.universjavamobile.sudoku.views.SudokuRecyclerViewAdapter;

public class GameActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //bouton pour effacer une case
    Button clean_btn;

    //bouton pour générer une nouvelle grille
    Button new_grid;

    //Dialog de victoire
    static Dialog you_win;


    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int sudokuDifficulty = getIntent().getIntExtra("SUDOKU_DIFFICULTY", 25);

        //Son de modification d'une case
        final MediaPlayer box_change_sound = MediaPlayer.create(this, R.raw
                .box_change_sound);

        //Son d'éffacement d'une case
        final MediaPlayer box_clean_sound = MediaPlayer.create(this, R.raw.box_clean_sound);

        you_win = new Dialog(this);
        clean_btn = findViewById(R.id.clean_btn);
        new_grid = findViewById(R.id.new_grid_btn);


        Context context;
        context = getApplicationContext();

        //Création d'une instance de sudoku
        Sudoku sudoku = new Sudoku(9, sudokuDifficulty);

        //Remplissage de la grille
        sudoku.fillValues();

        //Création du problème en fonction du niveau de difficulté
        sudoku.removeKDigits();


        //Grille de solution
        int[][] sudokuSolution = sudoku.getMat();

        //Grille de jeu
        int[][] sudokuGrid = sudoku.getProblem();

        recyclerView = findViewById(R.id.my_recycler_view);

        TableRow sudokuButtonGroup = findViewById(R.id.sudoku_button_group);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new SudokuRecyclerViewAdapter(sudokuGrid, sudokuSolution);
        recyclerView.setAdapter(mAdapter);

        new_grid.setOnClickListener(v -> {
            finish();
            startActivity(getIntent());
        });

        clean_btn.setOnClickListener(v -> {
            box_clean_sound.start();
            updateBox(0);
        });

        for(int i = 0; i < sudokuButtonGroup.getChildCount(); i++) {
            int finalI = i;
            sudokuButtonGroup.getChildAt(i).setOnClickListener(v -> {
                box_change_sound.start();
                updateBox(finalI + 1);
            });
        }
    }

    public static Context getAppContext() {
        return GameActivity.context;
    }

    public void updateBox(int value) {
        Box focusedBox = (Box) this.getCurrentFocus();
        if (value != 0)
            focusedBox.setText(value + "");
        else
            focusedBox.setText("");
    }

    public static void ShowPopup() {
        you_win.setContentView(R.layout.you_win);
        you_win.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics
                .Color.TRANSPARENT));
        you_win.show();
    }

    public void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}