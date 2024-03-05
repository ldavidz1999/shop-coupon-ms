package com.example.shopcouponms.Util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class ItemUtil {
    public List<String> removeDuplicates(List<String> list) {
        // Utiliza un LinkedHashSet para mantener el orden original y eliminar duplicados
        Set<String> set = new LinkedHashSet<>(list);
        // Crea una nueva lista a partir de los elementos únicos
        return new ArrayList<>(set);
    }
}
