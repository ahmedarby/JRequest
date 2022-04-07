package org.http.request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFile {
    private static final int BUFFER_SIZE = 4096;

    public static String download(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConnection.getHeaderField("Content-Disposition");
            String contentType = httpConnection.getContentType();
            int contentLength = httpConnection.getContentLength();

            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            }

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConnection.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");

            return saveFilePath;
        } else {
            System.out.println("File not downloaded successful, Status Code: " + responseCode);
        }

        httpConnection.disconnect();
        return null;
    }

}
