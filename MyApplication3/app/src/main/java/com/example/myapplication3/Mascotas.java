package com.example.myapplication3;


public class Mascotas {
    public String nombre;
    public String rating;
    public int imageFoto;
    public int likes;



    public Mascotas(String nombre, String rating, int imgFoto, int likes) {
        this.nombre = nombre;
        this.rating = rating;
        this.imageFoto = imgFoto;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImageFoto() {
        return imageFoto;
    }

    public void setImageFoto(int imageFoto) {
        this.imageFoto = imageFoto;
    }
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
