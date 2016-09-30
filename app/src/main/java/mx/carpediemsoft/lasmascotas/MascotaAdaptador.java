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
import android.widget.Toast;

import java.util.ArrayList;

import mx.carpediemsoft.lasmascotas.DB.ConstructorMascotas;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;
    Activity activity;
    int n = 1;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, MainActivity mainActivity) {
        this.mascotas = mascotas;
        this.activity = mainActivity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MascotaViewHolder(v);


    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {


        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.fotoPet.setImageResource(mascota.getFotoPet());
        mascotaViewHolder.huesoBlanco.setImageResource(mascota.getBotonLike());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getRating()));
        mascotaViewHolder.huesoAmarillo.setImageResource(mascota.getYellowBone());


        mascotaViewHolder.huesoBlanco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas =new ConstructorMascotas(activity);
                constructorMascotas.darLike(mascota);
               // mascotaViewHolder..setText(constructorMascotas.obtenerLikes(mascota));
                mascota.setRating(mascota.getRating() + 1);
                mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getRating()));
                mascotas.set(mascotaViewHolder.getAdapterPosition(), mascota);

            }
        });



    }

    @Override
    public int getItemCount() {

        return mascotas.size();

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

