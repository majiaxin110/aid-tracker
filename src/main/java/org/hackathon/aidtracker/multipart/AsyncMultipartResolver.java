package org.hackathon.aidtracker.multipart;

import org.apache.commons.fileupload.*;
import org.hackathon.aidtracker.config.AppContextAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//only POST method supported for uploading file
@Component("multipartResolver")
public class AsyncMultipartResolver extends CommonsMultipartResolver {
    private boolean resolveLazily;

    private static   Map<String,Anchor> excluded=new HashMap<>();


    static {
        excluded.put("/ttt",new Anchor("async","ok"));
        excluded.put("/test",new Anchor(new CustomRawStreamHandler(),"sss","ok"));

    }

    @Override
    protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
        return new AsyncFileUpload(excluded,fileItemFactory);
    }

    @Override
    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
        //return super.resolveMultipart(request);
        Assert.notNull(request, "Request must not be null");
        if (this.resolveLazily) {
            return new DefaultMultipartHttpServletRequest(request) {
                @Override
                protected void initializeMultipart() {
                    MultipartParsingResult parsingResult =parseRequest(request);
                    this.setMultipartFiles(parsingResult.getMultipartFiles());
                    this.setMultipartParameters(parsingResult.getMultipartParameters());
                    this.setMultipartParameterContentTypes(parsingResult.getMultipartParameterContentTypes());
                }
            };
        } else {
            MultipartParsingResult parsingResult = this.parseRequest(request);
            Anchor anchor = excluded.get(request.getRequestURI());
            if(anchor!=null){
                return new AsyncMultipartHttpServletRequest(request, parsingResult.getMultipartFiles(), parsingResult.getMultipartParameters(),
                        parsingResult.getMultipartParameterContentTypes(),anchor.rawStreamHandler);
            }
          return new DefaultMultipartHttpServletRequest(request, parsingResult.getMultipartFiles(), parsingResult.getMultipartParameters(),
                  parsingResult.getMultipartParameterContentTypes());
        }
    }

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = this.determineEncoding(request);
        AsyncFileUpload fileUpload = (AsyncFileUpload)this.prepareFileUpload(encoding);

        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            return this.parseFileItems(fileItems, encoding);
        } catch (FileUploadBase.SizeLimitExceededException var5) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), var5);
        } catch (FileUploadBase.FileSizeLimitExceededException var6) {
            throw new MaxUploadSizeExceededException(fileUpload.getFileSizeMax(), var6);
        } catch (FileUploadException var7) {
            throw new MultipartException("Failed to parse multipart servlet request", var7);
        }
    }

    static class Anchor {

        String[] fields;
        RawStreamHandler rawStreamHandler;

         Anchor (RawStreamHandler rawStreamHandler,String... fields){
           this.rawStreamHandler=rawStreamHandler;
           this.fields=fields;
       }
         Anchor (String... fields){
           this.rawStreamHandler= AppContextAccessor.getBean(DefaultRawStreamHandler.class);
           this.fields=fields;
       }

    }

}
