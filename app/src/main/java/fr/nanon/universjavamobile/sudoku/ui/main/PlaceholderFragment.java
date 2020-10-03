package fr.nanon.universjavamobile.sudoku.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import fr.nanon.universjavamobile.sudoku.GameActivity;
import fr.nanon.universjavamobile.sudoku.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static PlaceholderFragment newInstance() {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button easyButton = root.getRootView().findViewById(R.id.easyButton);
        Button mediumButton = root.getRootView().findViewById(R.id.mediumButton);
        Button hardButton = root.getRootView().findViewById(R.id.hardButton);

        easyButton.setOnClickListener(v -> {
            //NIVEAU FACILE
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra("SUDOKU_DIFFICULTY", 25);
            startActivity(intent);
        });

        mediumButton.setOnClickListener(v -> {
            //NIVEAU MOYEN
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra("SUDOKU_DIFFICULTY", 32);
            startActivity(intent);
        });

        hardButton.setOnClickListener(v -> {
            //NIVEAU DIFFICILE
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra("SUDOKU_DIFFICULTY", 40);
            startActivity(intent);
        });

        return root;
    }

}