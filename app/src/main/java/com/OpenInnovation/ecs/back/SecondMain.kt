package com.example.openinnovation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.OpenInnovation.ecs.back.Personne

class SecondMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second2)

        // On initialise notre liste de données
        List<Personne> listePersn = new ArrayList<>();
        listePersn.add(new Personne("Jean Jean", " salle 4", "11h00"));
        listePersne.add(new Personne("Jean Jean", "salle 2", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 2", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 1", "11h00");
        listePersn.add(new Personne("Jean Jean", "salle 3", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 3", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 5", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 4", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 5", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 1", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 1", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 6", "11h00"));
        listePersn.add(new Personne("Jean Jean", "salle 1", "11h00 "));
        listePersn.add(new Personne("Jean Jean", "salle 5", "11h00"));

        // On récupère notre RecyclerView via son id
        recyclerView = findViewById(R.id.personne_recyclerview);

        // On veut un RecyclerView qui utilise un LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // On donne notre adapter à notre RecyclerView
        personneAdapter = new PersonneAdapter(listePersn);
        recyclerView.setAdapter(personneAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
    }
}
