package org.service;


import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class ProductCategoryService {
    public LinkedHashMap<String,String> getAll()
    {
        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();
        hashMap.put("Laptop","Laptop");
        hashMap.put("Watch","Watch");
        hashMap.put("Mobile-phone","Mobile-phone");
        return hashMap;
    }
}
