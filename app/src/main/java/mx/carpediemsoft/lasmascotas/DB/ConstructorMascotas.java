package mx.carpediemsoft.lasmascotas.DB;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.carpediemsoft.lasmascotas.Mascota;
import mx.carpediemsoft.lasmascotas.R;

/**
 * Created by Usuario on 30/09/2016.
 */

        //Interactor

public class ConstructorMascotas {
    private static final int LIKE =1 ;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context= context;
    }

    public ArrayList<Mascota> obtenerDatos(){
      /*  ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
       mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.h2, "             Cheyenne", 2, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.cute, R.drawable.h2, "                  Gata", 5, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.cutedog, R.drawable.h2, "               Doggy", 5, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.dog, R.drawable.h2, "                 Pancho", 8, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.dogs, R.drawable.h2, "                  Scar",  9, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.hamster, R.drawable.h2, "               Noruego", 12, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.loro, R.drawable.h2, "                  Paco",  3, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.tortuga, R.drawable.h2, "               Donatello", 5, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.h2, "             Cheyenne", 10, R.drawable.h1));
    return mascotas;*/
        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerLasMascotas();
    }
public void insertarCincoMascotas (BaseDatos db){

    ContentValues contentValues=new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA, "Cheyenne");
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, 5);
    contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.bulldog);

    db.insertarMascota(contentValues);

    contentValues=new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA, "Gata");
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, 3);
    contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.cute);

    db.insertarMascota(contentValues);

    contentValues=new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA, "Doggy");
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, 2);
    contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.cutedog);

    db.insertarMascota(contentValues);

    contentValues=new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA, "Pancho");
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, 11);
    contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.dog);

    db.insertarMascota(contentValues);

    contentValues=new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA, "Noruergo");
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, 5);
    contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.hamster);

    db.insertarMascota(contentValues);
}
public void darLike (Mascota mascota){
    BaseDatos bd= new BaseDatos(context);
    ContentValues contentValues= new ContentValues();
    contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, LIKE);
    bd.insertarLike(contentValues);
}

    public int obtenerLikes (Mascota mascota){
    BaseDatos bd = new BaseDatos(context);
        return bd.obtenerLikes(mascota);

    }
}
