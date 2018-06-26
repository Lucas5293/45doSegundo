package com.mthumb.a45doSegundo.activies;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.mthumb.a45doSegundo.R;
import com.mthumb.a45doSegundoWeb.controllers.ControllerTeam;
import com.mthumb.a45doSegundoWeb.impl.ControllerTeamImpl;
import com.mthumb.a45doSegundoWeb.models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 25/06/2018.
 */

public class ConfiguracaoFragment extends Fragment {

    private View myView;
    private ControllerTeam controllerTeam;

    private ListView listView;
    private EditText editText;
    private Button button;
    private ArrayAdapter<String> adaptador;
    private List<Team> times;

    public ConfiguracaoFragment(){
        this.controllerTeam = new ControllerTeamImpl();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.content_configuracao, container, false);

        this.button = (Button) myView.findViewById(R.id.button);
        this.listView = (ListView) myView.findViewById(R.id.listView);
        this.editText = (EditText) myView.findViewById(R.id.editText);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Esconde o teclado */
                ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        editText.getWindowToken(), 0);

                times = findTimesByName(editText.getText().toString());
                populaListView(times);
            }
        });

        this.listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (times!=null){
                    ContentFragment.setTeam(times.get(i));
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.troca, new ContentFragment())
                            .commit();
                }
            }
        });

        return myView;
    }

    private List<Team> findTimesByName(String name){
        List<Team> teams = new ArrayList<>();
        try {
            teams = this.controllerTeam.getTeamByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams;
    }

    private void populaListView(List<Team> times){
        this.adaptador = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, this.teamsToString(times));
        this.listView.setAdapter(adaptador);
    }

    private List<String> teamsToString(List<Team> pets){
        List<String> teams  = new ArrayList<>();
        for (Team team : pets) {
            teams.add(team.getNome());
        }
        return teams;
    }

}
