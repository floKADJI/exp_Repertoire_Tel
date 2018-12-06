package com.example.florian.exp_repertoire_tel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        On récupère une ListView de notre layout en XML; c'est la vue qui représente la liste
        vue = (ListView) findViewById(R.id.listView);

/*      On entrepose nos données dans un table qui contient deux colonnes:
        - La première contiendra le nom de l'utilisateur
        - la seconde contiendra le numéro de téléphone de l'utilisateur
 */
        String [][] repertoire = new String[][]{
                {"Bill Gates", "01 01 01 01 01"},
                {"Niels Bohr", "02 02 02 02 02"},
                {"Alexandre III", "03 03 03 03 03"}
        };

/*      On doit donner à notre adaptateur une liste du type " List<Map<String, ?  " :
        - la clé doit forcément être une chaîne de caractères
        - en revanche, la valeur peut être n'importe quoi, un objet ou un entier par exemple,
        si c'est un objet, on affichera son contenu avec la méthode " toString() "
        Dans notre cas, la valeur sera une chaîne de caractères, puis le nom et le numéro de téléphone sont entreposés dans des chaînes de caractères
 */
        List<HashMap<String, String>> liste = new ArrayList<>();

        HashMap<String, String> element;
//        Pour chaque personne dans notre répertoire...
        for(int i=0; i < repertoire.length; i++){
//            ... on crée un élément pour la liste ...
            element = new HashMap<>();
//            ... on déclare que la clé est "text1" pour le nom de la personne (première dimension du tableau de valeurs)...
             element.put("text1", repertoire[i][0]);
//            ... on déclare que la clé est "text1" pour le numéro de cette personne (seconde dimension du tableau de valeurs)...
            element.put("text2", repertoire[i][1]);
            liste.add(element);
        }

        ListAdapter adapter = new SimpleAdapter(this,
//                Valeurs à insérer
                liste,
//                Layout de chaque élément (là, il s'agit d'un layout par défaut pour avoir deux textes
                android.R.layout.simple_list_item_2,
/*
                Les clés des informations à afficher pur chaque élément:
                - la valeur associée à la clé "text1" sera la première information
                - la valeur associée à la clé "text2" sera la second information
 */
                new String[]{"text1", "text2"},
/*
                Enfin, les layouts à appliquer à chaque widget de notre élément (ce sont des layouts fournis par défauts):
                - la première information appliquera le layout "android.R.id.text1"
                - la seconde information appliquera le layout "android.R.id.text2"
 */
                new int[]{android.R.id.text1, android.R.id.text2});

//      Pour finir, on donne à la ListView le SimpleAdapter
        vue.setAdapter(adapter);
    }
}
