package org.hackathon.aidtracker.multipart;

import org.apache.commons.fileupload.FileItemStream;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AsyncMultipartHttpServletRequest extends DefaultMultipartHttpServletRequest {

    private RawStreamHandler rawStreamHandler;

    public AsyncMultipartHttpServletRequest(HttpServletRequest request, MultiValueMap<String, MultipartFile> mpFiles,
                                            Map<String, String[]> mpParams, Map<String, String> mpParamContentTypes,
                                            RawStreamHandler rawStreamHandler) {
        super(request, mpFiles, mpParams, mpParamContentTypes);
        this.rawStreamHandler=rawStreamHandler;
    }

    public AsyncMultipartHttpServletRequest(HttpServletRequest request) {
        super(request);
    }


    public RawStreamHandler getRawStreamHandler() {
        return rawStreamHandler;
    }
}
