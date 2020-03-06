package org.hackathon.aidtracker.system.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageHelper {
    private static final int DEFAULT_PAGE_SIZE = 20;

    public static Pageable build(int pageNum, int pageSize) {
        if (pageNum < 1) pageNum = 1;
        --pageNum;
        if (pageSize < 1) pageSize = DEFAULT_PAGE_SIZE;
        return PageRequest.of(pageNum, pageSize);
    }
}
