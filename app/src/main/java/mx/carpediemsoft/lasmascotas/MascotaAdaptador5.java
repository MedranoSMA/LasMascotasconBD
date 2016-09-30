package mx.carpediemsoft.lasmascotas;


import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MascotaAdaptador5 extends RecyclerView.Adapter<MascotaAdaptador5.MascotaViewHolder>{

    ArrayList<Mascota> masc5fav;
    Activity activity;
    int n = 1;
    public MascotaAdaptador5(ArrayList<Mascota> masc5fav, Mascotas5 mascotas5) {
        this.masc5fav = masc5fav;
        this.activity = mascotas5;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MascotaViewHolder(v);


    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {

        final Mascota mascotafav = masc5fav.get(position);
        mascotaViewHolder.fotoPet.setImageResource(mascotafav.getFotoPet());
        mascotaViewHolder.huesoBlanco.setImageResource(mascotafav.getBotonLike());
        mascotaViewHolder.tvNombreCV.setText(mascotafav.getNombre());
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascotafav.getRating()));
        mascotaViewHolder.huesoAmarillo.setImageResource(mascotafav.getYellowBone());


    }

    @Override
    public int getItemCount() {

        return masc5fav.size();

    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoPet;
        private ImageView huesoBlanco;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
        private ImageView huesoAmarillo;
        private CardView mascotita;



        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoPet = (ImageView) itemView.findViewById(R.id.imgvfoto);
            huesoBlanco = (ImageView) itemView.findViewById(R.id.boton_likes);
            tvNombreCV = (TextView) itemView.findViewById(R.id.nombre_mascota);
            tvRatingCV = (TextView) itemView.findViewById(R.id.numero_likes);
            huesoAmarillo = (ImageView) itemView.findViewById(R.id.hueso_amarillo);
            mascotita = (CardView) itemView.findViewById(R.id.cvPet);

        }

    }
}
