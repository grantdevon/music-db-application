package com.company;

import com.company.model.Artists;
import com.company.model.DataSource;

import java.util.List;

public class Main {


    public static void main(String[] args) {
	// write your code here
        DataSource dataSource = new DataSource();
        if (!dataSource.open()){
            System.out.println("cant open datasource");
            return;
        }

        List<Artists> artists = dataSource.queryArtist(DataSource.ORDER_BY_NONE);
        if (artists == null){
            System.out.println("no artists");
            return;
        }

        for (Artists artist: artists){
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Elf",DataSource.ORDER_BY_ASC);
        for (String album: albumsForArtist){
            System.out.println(album);
        }
        dataSource.close();
    }
}
