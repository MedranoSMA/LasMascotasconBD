package mx.carpediemsoft.lasmascotas;


import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Mascotas5 extends AppCompatActivity {

    ArrayList<Mascota> masc5fav;
    private RecyclerView listaMascotas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas5);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaMascotas = (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarLista5Favoritas();
        inicializarAdaptador();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_5, menu);

               return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent i = new Intent(this, Contacto.class);
                startActivity(i);
                break;

            case R.id.mSettings:
                Intent i2 = new Intent(this, Acerca_de.class);
                startActivity(i2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador5 adaptador;
    public void inicializarAdaptador(){
        adaptador =new MascotaAdaptador5(masc5fav, this);
        listaMascotas.setAdapter(adaptador);}

    public void inicializarLista5Favoritas(){

        Bundle extras = getIntent().getExtras();
        masc5fav = new ArrayList<Mascota>();
        Mascota masc5fav1 = extras.getParcelable("mascota1");
        Mascota masc5fav2 = extras.getParcelable("mascota2");
        Mascota masc5fav3 = extras.getParcelable("mascota3");
        Mascota masc5fav4 = extras.getParcelable("mascota4");
        Mascota masc5fav5 = extras.getParcelable("mascota5");

        masc5fav.add(masc5fav1);
        masc5fav.add(masc5fav2);
        masc5fav.add(masc5fav3);
        masc5fav.add(masc5fav4);
        masc5fav.add(masc5fav5);

    }
}
