package com.example.admin.myapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.database.DatabaseManager;
import com.example.admin.myapplication.fragments.MissionsFragment;
import com.example.admin.myapplication.models.Mission;
import com.example.admin.myapplication.models.Task;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Mission mission1 = new Mission(1,"Missão 1 - Uma Nova Jornada",
                "Você recebeu uma misteriosa carta que o convidava pra uma associação onde os integrantes se dedicavam a tentar solucionar casos, mas parece que para participar desse grupo você deve provar suas habilidades. Vá até as coordenadas que estão na carta e descubra mais sobre esse grupo.",0);
        Task task1 = new Task(1,1,"A estatua dos tropeiros",
                "Você chegou no local que a carta indicava, e encontrou o monumento ao tropeiros. Vasculhando a área você encontrou as lentras JK e uma bandeira do Brasil e o ano 1958, o que essas letras podem significar?",
                "Juscelino Kubitshek",0,0, false, 1,
                "o monumento 'Os Pioneiros da Borborema' virou ponto turístico do município. Instaladas às margens do Açude Velho, as estátuas foram trazidas do Rio de Janeiro e apresentam três figuras que ajudaram a criar a cidade. O índio representa o início de tudo. A catadora de algodão faz referência à 'Era de Ouro' de Campina Grande, quando o município se tornou o segundo maior exportador de algodão do mundo. E o tropeiro presta homenagem à vocação comerciária da cidade.",
                "Você descobriu que JK significa Juscelino Kubitshek, você deve ir onde Juscelino Kubitshek e o ano de 1958 tem algum significado para descobrir a nova pista.");

        DatabaseManager.addMission(mission1,this);
        DatabaseManager.addTask(task1,this);

        setFrag(MissionsFragment.newInstance(this));
    }

    public void setFrag(Fragment frag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.main_frame, frag);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
