package com.prykhodko;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();


    private static void playTrack(LinkedList<Song> playList){
        
        ListIterator<Song> iterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("The playlist is empty");
        }else{
            System.out.println(iterator.next().toString() + " is playing");
        }
    }






    public static void main(String[] args) {

        Album albumBeatles = new Album("Let it be", "The Beatles");
        albumBeatles.addSong("Two of us", 3.36);
        albumBeatles.addSong("Dig a pony", 3.54);
        albumBeatles.addSong("Across the universe", 3.47);
        albumBeatles.addSong("I me mine", 2.26);
        albumBeatles.addSong("Dig it", 0.50);
        albumBeatles.addSong("Let it be", 4.03);
        albumBeatles.addSong("Maggie Mae", 0.40);
        albumBeatles.addSong("I've got a feeling", 3.37);
        albumBeatles.addSong("One after 909", 2.53);
        albumBeatles.addSong("The long and winding road", 3.38);
        albumBeatles.addSong("For you blue", 2.32);
        albumBeatles.addSong("Get back", 3.07);
        albums.add(albumBeatles);

        Album albumTiesto = new Album("Elements of life", "Tiesto");
        albumTiesto.addSong("Ten seconds before sunrize", 7.31);
        albumTiesto.addSong("Everything", 7.01);
        albumTiesto.addSong("Do you feel me", 6.03);
        albumTiesto.addSong("Carpe Noctum", 7.03);
        albumTiesto.addSong("Driving to heaven", 4.42);
        albumTiesto.addSong("Sweet things", 5.42);
        albumTiesto.addSong("Bright morningstar", 8.19);
        albumTiesto.addSong("Break my fall", 7.14);
        albums.add(albumTiesto);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addSongToPlaylist("Two of us", playList);
        albums.get(0).addSongToPlaylist("I me mine", playList);
        albums.get(0).addSongToPlaylist("One after 909", playList);
        albums.get(0).addSongToPlaylist("Sweet things", playList);


        albums.get(1).addSongToPlaylist("Do you feel me", playList);
        albums.get(1).addSongToPlaylist("Bright morningstar", playList);
        albums.get(1).addSongToPlaylist("Break my fall", playList);

        playTrack(playList);




    }
}
