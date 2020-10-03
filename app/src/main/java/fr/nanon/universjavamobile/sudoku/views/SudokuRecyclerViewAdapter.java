package fr.nanon.universjavamobile.sudoku.views;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import fr.nanon.universjavamobile.sudoku.GameActivity;
import fr.nanon.universjavamobile.sudoku.R;
import fr.nanon.universjavamobile.sudoku.customui.Box;

public class SudokuRecyclerViewAdapter extends RecyclerView.Adapter<SudokuRecyclerViewAdapter
        .MyViewHolder> {
    private int[][] mDataset;
    private int[][] sudokuSolution;
    private int[] possibleValue;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TableLayout tableLayout;
        public MyViewHolder(TableLayout v) {
            super(v);
            tableLayout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SudokuRecyclerViewAdapter(int[][] myDataset, int[][] sudoku_solution) {
        mDataset = myDataset;
        sudokuSolution = sudoku_solution;
        possibleValue = new int[]{1,2,3,4,5,6,7,8,9};
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SudokuRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        // create a new view
        TableLayout v = (TableLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sample_region, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //Récupère la seul et unique ligne d'un élément du RecyclerView
        TableRow current_row = (TableRow) holder.tableLayout.getChildAt(0);

        for(int i = 0, j = current_row.getChildCount(); i < j; i++) {

            int finalI = i;

            //récupère la case à l'emplacement abscisse = position et ordonnée = i
            //du jeu de soduku
            Box box = (Box) current_row.getChildAt(i);

            //Applique un design spécique à la case en fonction de sn=on emplacement
            if(position == 2 || position == 5) {
                if(i == 2 || i == 5) {
                    box.setBackgroundResource(R.drawable.box_background7);
                } else {
                    if(i == 8) {
                        box.setBackgroundResource(R.drawable.box_background8);
                    } else {
                        box.setBackgroundResource(R.drawable.box_background6);
                    }
                }
            } else {
                if(i == 2 || i == 5) {
                    box.setBackgroundResource(R.drawable.box_background5);
                } else {
                    if(i == 8) {
                        box.setBackgroundResource(R.drawable.box_background4);
                    } else {
                        box.setBackgroundResource(R.drawable.box_background2);
                    }
                }

            }

            //Si la case est une case mystère du sudoku
            if(mDataset[position][i] == 0) {

                //définition des attributs de l'objet
                box.hidden = true;
                box.position_Y = i;
                box.position_X = position;
                box.value = mDataset[position][i];

                //parametrage de l'objet
                box.setTextColor(Color.parseColor("#389fd6"));
                box.setInputType(EditorInfo.TYPE_NULL);
                box.setShowSoftInputOnFocus(false);
                box.requestFocus();


                box.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        //Logique de changement de style de la case
                        if (hasFocus) {
                            if(box.position_X == 2 || box.position_X == 5) {
                                if(box.position_Y == 2 || box.position_Y == 5) {
                                    box.setBackgroundResource(R.drawable.gray_box_background7);
                                } else {
                                    if(box.position_Y == 8) {
                                        box.setBackgroundResource(R.drawable.gray_box_background8);
                                    } else {
                                        box.setBackgroundResource(R.drawable.gray_box_background6);
                                    }
                                }
                            } else {
                                if(box.position_Y == 2 || box.position_Y == 5) {
                                    box.setBackgroundResource(R.drawable.gray_box_background5);
                                } else {
                                    if(box.position_Y == 8) {
                                        box.setBackgroundResource(R.drawable.gray_box_background4);
                                    } else {
                                        box.setBackgroundResource(R.drawable.gray_box_background2);
                                    }
                                }

                            }
                        } else {
                            if(box.position_X == 2 || box.position_X == 5) {
                                if(box.position_Y == 2 || box.position_Y == 5) {
                                    box.setBackgroundResource(R.drawable.box_background7);
                                } else {
                                    if(box.position_Y == 8) {
                                        box.setBackgroundResource(R.drawable.box_background8);
                                    } else {
                                        box.setBackgroundResource(R.drawable.box_background6);
                                    }
                                }
                            } else {
                                if(box.position_Y == 2 || box.position_Y == 5) {
                                    box.setBackgroundResource(R.drawable.box_background5);
                                } else {
                                    if(box.position_Y == 8) {
                                        box.setBackgroundResource(R.drawable.box_background4);
                                    } else {
                                        box.setBackgroundResource(R.drawable.box_background2);
                                    }
                                }

                            }
                        }
                    }
                });

                box.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {//Code de mise à jour de la grille de jeu
                        int newVal;
                        try {
                            newVal = Integer.parseInt(String.valueOf(box.getText()));
                        } catch (Exception e) {
                            newVal = 0;
                        }

                        //On verifie que l'entrée est bien comprise entre 1 et 9
                        if(contains(possibleValue, newVal)) {
                            //On met à jour la case dans la grille de jeu
                            mDataset[position][finalI] = newVal;

                            //On regarde si la grille de jeu est égale à la grille de solution
                            if (Arrays.deepEquals(mDataset, sudokuSolution)) {
                                //Victoire !!
                                Log.i("GAME_COMPLETED", "YOU WIN !");
                                GameActivity.ShowPopup();
                            } else {
                                //Sudoku incomplet on continue
                                Log.i("STILL_NOT_COMPLETED", "CONTINUE !");
                            }
                        }
                        else { //Sinon on marque la case comme étant vide
                            mDataset[position][finalI] = 0;
                        }

                    }
                });
            } else { //Si la case est une case connu du sudoku
                box.hidden = false;
                box.position_Y = i;
                box.position_X = position;
                box.value = mDataset[position][i];
                box.setText(mDataset[position][i] + "");
                box.setTextColor(Color.BLACK);
                box.setEnabled(false);
            }
        }

    }

    //Recherche d'un entier dans un tableau
    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
