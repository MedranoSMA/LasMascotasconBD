package mx.carpediemsoft.lasmascotas;

import java.util.ArrayList;

/**
 * Created by Usuario on 30/09/2016.
 */
public interface IMascotas {

public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
