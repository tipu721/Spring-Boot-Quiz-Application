package com.tipu.main.base;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaseService {


    public Pageable preparePageRequest(Map<String,Object> reqMap) {

        Integer start = Integer.valueOf((String) reqMap.get("start"));
        Integer length = Integer.valueOf((String) reqMap.get("length"));
        Pageable pagereq = null;

        if(reqMap.get("order[0][column]") != null){

            Integer sortColumnNo = Integer.valueOf((String) reqMap.get("order[0][column]"));
            String mapKey = "columns["+sortColumnNo+"][data]";
            String  sortColumnName = (String) reqMap.get(mapKey);
            if(reqMap.get("order[0][dir]").equals("desc")){
                pagereq = PageRequest.of((start/length), length, Sort.by(Sort.Direction.DESC,sortColumnName));
            }
            else if(reqMap.get("order[0][dir]").equals("asc")) {
                pagereq = PageRequest.of((start/length), length, Sort.by(Sort.Direction.ASC,sortColumnName));
            }

        }
        else{
            pagereq = PageRequest.of((start/length), length);
        }

        return pagereq;
    }
}
