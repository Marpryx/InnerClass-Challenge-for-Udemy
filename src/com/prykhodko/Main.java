//Create a program that implements a playlist for songs
//Create a Song class having Title and Duration for the song
//The program will have an Album class containing a list of the songs
//The albums will be stored  in an ArrayList
//Songs from different albums can be added to the playlist and will appear in the list in order they are added
//Once the songs have been added to the playlist, create a menu of the options
//Quit, Scip, forward to the next song, skip backwards to a previous song, replay the current song
//Print the playlist
//The song must exist in an album before it can be added to the playlist
//Remove the current song from the playlist


    //****Inner class challenge****/////
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.



package com.prykhodko;

import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();


    private static void playTrack(List<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quitTheProgramm = false;
        boolean forward = true;

        ListIterator<Song> iterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("The playlist is empty");
        }else{
            System.out.println(iterator.next().toString() + " is playing");
        }
        printMenu();
        while(!quitTheProgramm){
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    System.out.println("Exit");
                    quitTheProgramm = true;
                    break;
                case 1:
                    if(!forward){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        forward = true;
                    }
                    if(iterator.hasNext()) {
                        System.out.println(iterator.next() + " is playing");
                    }else{
                            System.out.println("The end of the playlist");
                            forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous().toString() + " is playing");
                    }else{
                        System.out.println("The start of the playlist");
                        forward = true;
                    }

                    break;

                case 3:
                    if(forward){
                        if(iterator.hasPrevious()){
                            System.out.println(iterator.previous() + " is playing");
                            forward = false;
                        }else{
                            System.out.println("It is a start of the list");
                        }
                    }else{
                        if(iterator.hasNext()){
                            System.out.println(iterator.next() + " is replaying");
                            forward = true;
                        }else{
                            System.out.println("The end of the list");
                        }
                    }
                    break;

                case 4:
                    if(playList.size() > 0){
                        iterator.remove();
                        if(iterator.hasNext()){
                            System.out.println(iterator.next() + " is playing");
                        }else{
                            System.out.println(iterator.previous() + " is playing");
                        }
                    }
                    break;

                case 5:
                    printPlaylist(playList);
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }


    }


    private static void printMenu(){
        System.out.println("=========================");
        System.out.println("Press the menu:\n " +
                "0 - Exit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - replay the current song\n" +
                "4 - remove the song from the playlist\n" +
                "5 - print the playlist\n " +
                "6 - print the menu");
    }

    private static void printPlaylist(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
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
