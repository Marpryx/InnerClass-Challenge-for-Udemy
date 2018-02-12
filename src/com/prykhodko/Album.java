package com.prykhodko;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String albomTitle;
    private String artist;
    private ArrayList<Song> songs;


    public Album(String albomTitle, String artist) {
        this.albomTitle = albomTitle;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }


    public Song findSong(String songTitle){
        for(Song findSong: this.songs){
            if(findSong.getTitle().equalsIgnoreCase(songTitle)){
                return findSong;
            }
        }
        return null;
    }

//The old way by using for loop
//
//    public Song findSong(String songTitle){
//        for(int i=0; i<songs.size(); i++){
//            Song findSong = songs.get(i);
//            if(findSong.getTitle() == songTitle){
//                return findSong;
//            }
//        }
//        return null;
//    }

    public boolean addSong(String songTitle, double durations){

        if(findSong(songTitle) == null){
            this.songs.add(new Song(songTitle, durations));
            return true;
        }
        return false;
    }

    public boolean addSongToPlaylist(String songTitle, List<Song> playList){

        Song findSong = findSong(songTitle);
        if(findSong != null){
            playList.add(findSong);
            return true;
        }
        System.out.println(songTitle + " is not in the album");
        return false;
    }
}
