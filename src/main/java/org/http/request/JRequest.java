package org.http.request;

import java.io.IOException;

public class JRequest {

    public static void main(String[] args) {
        String fileURL = "https://www.itl.cat/pngfile/big/251-2518532_butuh-yang-keren-ini-21-wallpaper-spongebob-cakep.jpg";
        String saveDir = "/home/ahmed/Desktop/";

        try {
            System.out.println(DownloadFile.download(fileURL, saveDir));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
