package mx.carpediemsoft.lasmascotas.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.carpediemsoft.lasmascotas.Mascota;

/**
 * Created by Usuario on 30/09/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA + "(" +
                                   ConstantesBD.TABLE_MASCOTA_ID                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                   ConstantesBD.TABLE_MASCOTA_NOMBRE_MASCOTA    + " TEXT, " +
                                   ConstantesBD.TABLE_MASCOTA_LIKES             + " INTEGER, " +
                                   ConstantesBD.TABLE_MASCOTA_FOTO              + " INTEGER" +
                                    ")";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerLasMascotas(){

        ArrayList<Mascota> mascotas =new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =db.rawQuery(query, null);
        while (registros.moveToNext()){

            Mascota mascotaActual=new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRating(registros.getInt(2));
            mascotaActual.setFotoPet(registros.getInt(3));
            String queryLikes="SELECT COUNT("+ConstantesBD.TABLE_MASCOTA_LIKES+") as likes " +
                               " FROM " + ConstantesBD.TABLE_MASCOTA +
                                " WHERE " + ConstantesBD.TABLE_MASCOTA_ID + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRating(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA,null, contentValues);
        db.close();
    }

    void insertarLike (ContentValues contentValues){
        SQLiteDatabase bd= this.getWritableDatabase();
        bd.insert(ConstantesBD.TABLE_MASCOTA, null, contentValues);
        bd.close();
    }
    public int obtenerLikes (Mascota mascota){
        int likes=0;
        String query= "SELECT COUNT("+ConstantesBD.TABLE_MASCOTA_LIKES+")"+
                        " FROM "+ ConstantesBD.TABLE_MASCOTA +
                        " WHERE " + ConstantesBD.TABLE_MASCOTA_ID + "=" + mascota.getId();

        SQLiteDatabase bd= this.getWritableDatabase();
        Cursor registros = bd.rawQuery(query, null);
        if (registros.moveToNext()) {
        likes=registros.getInt(0);
        }
        bd.close();
        return likes;

    }
}
