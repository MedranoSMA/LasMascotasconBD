package mx.carpediemsoft.lasmascotas.Presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.carpediemsoft.lasmascotas.DB.ConstructorMascotas;
import mx.carpediemsoft.lasmascotas.Mascota;
import mx.carpediemsoft.lasmascotas.MascotaAdaptador;
import mx.carpediemsoft.lasmascotas.IMascotas;

/**
 * Created by Usuario on 30/09/2016.
 */
public class MascotasPresenter implements IMascotasPresenter {

    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private  IMascotas iMascotas;
    private Context context;

    public MascotasPresenter(IMascotas iMascotas, Context context) {
        this.iMascotas =iMascotas;
        this.context=context;
        obtenerDeLaBaseDatos();

    }

    @Override
    public void obtenerDeLaBaseDatos() {
        constructorMascotas =new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
        }

    @Override
    public void mostrarMascotasRV() {
    iMascotas.inicializarAdaptadorRV(iMascotas.crearAdaptador(mascotas));
        iMascotas.generarLinearLayoutVertical();
    }
}
