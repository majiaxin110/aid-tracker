package org.hackathon.aidtracker.multipart;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AsyncFileUpload extends ServletFileUpload {

    private Map<String, AsyncMultipartResolver.Anchor> anchors;

    AsyncFileUpload(Map<String, AsyncMultipartResolver.Anchor> anchors,FileItemFactory fileItemFactory){
        this.anchors=anchors;
        super.setHeaderEncoding(StandardCharsets.UTF_8.name());
        this.setFileItemFactory(fileItemFactory);
    }


    @Override
    public void setFileItemFactory(FileItemFactory factory) {
        super.setFileItemFactory(factory);
    }

    @Override
    public List<FileItem> parseRequest(HttpServletRequest request) throws FileUploadException {
        ServletRequestContext ctx = new ServletRequestContext(request);
        List<FileItem> items = new ArrayList<>();
        boolean var21 = false;
        FileItem fileItem;
        List<FileItem> var29;
        try {
            var21 = true;
            FileItemIterator iter = this.getItemIterator(ctx);
            FileItemFactory fac = this.getFileItemFactory();
            if (fac == null) {
                throw new NullPointerException("No FileItemFactory has been set.");
            }

            AsyncMultipartResolver.Anchor anchor = anchors.get(request.getRequestURI());
            while(true) {
                if (!iter.hasNext()) {
                    var29 = items;
                    var21 = false;
                    break;
                }

                FileItemStream item = iter.next();

                if(anchor!=null){
                    boolean flg=false;
                    for (String s : anchor.fields) {

                        if(Objects.equals(s, item.getFieldName())){
                            flg=true;
                            break;
                        }
                    }
                    if(flg){
                        anchor.rawStreamHandler.putItemStream(item.getFieldName(),item);
                        continue;
                    }
                }

                fileItem = fac.createItem(item.getFieldName(), item.getContentType(), item.isFormField(),  item.getName());

                items.add(fileItem);

                try {
                    Streams.copy(item.openStream(), fileItem.getOutputStream(), true);
                } catch (FileUploadBase.FileUploadIOException var24) {
                    throw (FileUploadException)var24.getCause();
                } catch (IOException var25) {
                    throw new FileUploadBase.IOFileUploadException(String.format("Processing of %s request failed. %s", "multipart/form-data", var25.getMessage()), var25);
                }

                FileItemHeaders fih = item.getHeaders();
                fileItem.setHeaders(fih);
            }
        } catch (FileUploadBase.FileUploadIOException var26) {
            throw (FileUploadException)var26.getCause();
        } catch (IOException var27) {
            throw new FileUploadException(var27.getMessage(), var27);
        } finally {
            if (var21) {

                for (FileItem fileItem1 : items) {
                    try {
                        fileItem1.delete();
                    } catch (Exception ignored) {
                    }
                }

            }
        }

        return var29;
    }
}
