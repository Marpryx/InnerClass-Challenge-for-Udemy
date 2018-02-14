package com.prykhodko;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumTitle;
    private String artist;
//    private ArrayList<Song> songs;
    private SongList songs;


    public Album(String albomTitle, String artist) {
        this.albumTitle = albomTitle;
        this.artist = artist;
        this.songs = new SongList();

    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    }


    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){

            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        public Song findSong(String songTitle){
            for(Song findSong: this.songs){
                if(findSong.getTitle().equalsIgnoreCase(songTitle)){
                    return findSong;
                }
            }
            return null;
        }
    }


    public boolean addSongToPlaylist(String songTitle, List<Song> playList){

        Song findSong = this.songs.findSong(songTitle);
        if(findSong != null){
            playList.add(findSong);
            return true;
        }
        System.out.println(songTitle + " is not in the album");
        return false;
    }
}
