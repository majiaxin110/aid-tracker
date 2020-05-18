package org.hackathon.aidtracker.multipart;

import org.apache.commons.fileupload.FileItemStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class RawStreamHandler {
    boolean before=false;
    private Map<String ,FileItemStream> map =new HashMap<>();
     void writeTo(String field, String filepath){

    }
    abstract void relayWrite();
    public  Map<String ,FileItemStream> getItemStreamMap(){
       return map;
    }

    void putItemStream(String itemName,FileItemStream fis){
         map.put(itemName,fis);
    }
}
