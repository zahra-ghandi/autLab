package com.company;

import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing musics.
    private ArrayList<Music> musics;
    // An ArrayList for Storing favorite songs.
    private ArrayList<Music> favorites;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        musics = new ArrayList<>();
        favorites = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param fileName The file, artistName the artist's name, releaseYear the year of release to be added.
     */
    public void addFile(String fileName, String artistName, String releaseYear)
    {
        musics.add(new Music(fileName, artistName, releaseYear));
    }
    /**
     * Add a file to the collection.
     * @param newMusic
     */
    public void addFile(Music newMusic)
    {
        musics.add(newMusic);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return musics.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index) == true) {
            System.out.println(musics.get(index).getFile() + " : " + musics.get(index).getArtist() + " : " + musics.get(index).getYear());
        } else {
            System.out.println("Index not valid.");
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(Music music : musics) {
            System.out.println(music.getFile());
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index) == true) {

            for (int i = 0; i < favorites.size(); i++) {
                if (favorites.get(i).equals(musics.get(index))) {
                    favorites.remove(i);
                    break;
                }
            }
            musics.remove(index);
        } else  {
            System.out.println("Index not valid.");
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index) == true) {
            player.startPlaying(musics.get(index));
        } else {
            System.out.println("Invalid index.");
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Add a music to your favorites
     * @param index The index of the favorite music to be added.
     */
    public void addFavorite(int index) {
        if(validIndex(index) == true) {
            favorites.add(musics.get(index));
        } else {
            System.out.println("Invalid index.");
        }
    }
    /**
     * Add a music to your favorites
     * @param favoriteMusic
     */
    public void addFavorite(Music favoriteMusic) {
        boolean isMusic = false;
        for(Music music : musics) {
            if(music.equals(favoriteMusic)) {
                isMusic = true;
                break;
            }
        }
        if(isMusic) {
            favorites.add(favoriteMusic);
        } else {
            System.out.println("This music does not exist.");
        }
    }

    /**
     * Remove a music from your favorites
     * @param index The index of the favorite music to be removed.
     */
    public void removeFavorite(int index) {
        favorites.remove(index);
    }
    /**
     * Remove a music from your favorites
     * @param musicToBeRemoved
     */
    public void removeFavorite(Music musicToBeRemoved) {
        favorites.remove(musicToBeRemoved);
    }

    /**
     * Show a list of all the favorite music.
     */
    public void showFavorite() {
        for(Music favorite : favorites) {
            System.out.println(favorite.getFile() + " : " + favorite.getArtist() + " : " + favorite.getYear());
        }
    }

    /**
     * Search through the songs
     * @param searchKey the String to be searched.
     */
    public void search(String searchKey) {
        for(Music music : musics){
            if(music.getFile().contains(searchKey)) {
                System.out.println(music.getFile());
            }
        }
        for(Music music : musics){
            if(music.getArtist().contains(searchKey)) {
                System.out.println(music.getFile() + "   artist: " + music.getArtist());
            }
        }
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        if( index >= 0 && index < musics.size()){
            return true;
        } else {
            return false;
        }
    }
}