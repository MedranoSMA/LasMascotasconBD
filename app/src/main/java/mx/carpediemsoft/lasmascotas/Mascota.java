package mx.carpediemsoft.lasmascotas;

import android.os.Parcel;
import android.os.Parcelable;


public class Mascota implements Parcelable {

    private int id;
    private int fotoPet;
    private int botonLike;
    private String nombre;
    private int rating;
    private int yellowBone;



    public Mascota(int fotoPet, int botonLike, String nombre, int rating, int yellowBone) {

        this.fotoPet = fotoPet;
        this.botonLike = botonLike;
        this.nombre = nombre;
        this.rating = rating;
        this.yellowBone = yellowBone;

    }

    protected Mascota(Parcel in) {
        fotoPet = in.readInt();
        botonLike = in.readInt();
        nombre = in.readString();
        rating = in.readInt();
        yellowBone = in.readInt();
    }

    public Mascota() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFotoPet() {
        return fotoPet;
    }

    public void setFotoPet(int fotoPet) {
        this.fotoPet = fotoPet;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {

        this.rating = rating;

    }

    public int getYellowBone() {
        return yellowBone;
    }

    public void setYellowBone(int yellowBone) {
        this.yellowBone = yellowBone;
    }
    public int getBotonLike() {
        return botonLike;
    }

    public void setBotonLike(int botonLike) {
        this.botonLike = botonLike;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(fotoPet);
        parcel.writeInt(botonLike);
        parcel.writeString(nombre);
        parcel.writeInt(rating);
        parcel.writeInt(yellowBone);
    }

    @SuppressWarnings("unused")
    public static Parcelable.Creator<Mascota> CREATOR = new Parcelable.Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
