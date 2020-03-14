package com.company;

public class Music {
    private String file;
    private String artist;
    private String year;

    /**
     * Create a Music.
     * @param fileName
     * @param artistName
     * @param releaseYear
     */
     public Music(String fileName, String artistName, String releaseYear) {
        file = fileName;
        artist = artistName;
        year = releaseYear;
    }

    /**
     * Get file's name.
     * @return file
     */
    public String getFile() {
        return file;
    }

    /**
     * Get file's artist.
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Get file's release year.
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Check if two musics are the same.
     */
    public boolean equals(Music musicToCheck) {
        if(musicToCheck.getFile().equals(file) && musicToCheck.getArtist().equals(artist) && musicToCheck.getYear().equals(year)) {
            return true;
        }

        return false;
    }
}
