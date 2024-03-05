package com.example.shopcouponms.Controller;

import com.example.shopcouponms.Model.Request.CouponRequest;
import com.example.shopcouponms.Model.Response.CouponResponse;
import com.example.shopcouponms.Service.FavoriteStatService;
import com.example.shopcouponms.Service.ItemRestService;
import com.example.shopcouponms.Util.ItemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop-coupon/api/")
public class CouponController {
    @Autowired
    private ItemRestService itemRestService;
    @Autowired
    private FavoriteStatService favoriteStatService;
    @Autowired
    private ItemUtil itemUtil;
    @PostMapping("/coupon")
    public ResponseEntity<CouponResponse> getCouponListMaxToBuy(@RequestBody CouponRequest request){
        Long amount = request.getAmount();
        List<String> itemList = request.getItemList();
        // Obtener la lista de objetos unicos
        itemList = itemUtil.removeDuplicates(itemList);
        CouponResponse responseCouponMaxToBuy = new CouponResponse();
        List<String> itemListResponse = new ArrayList<>();
        double amountTotal = 0.0;
        // recorrer arreglo
        for (String item : itemList) {
            // ir a base de datos e insertar el itemId en la tabla states
            favoriteStatService.saveOrUpdateFavoriteStat(item);
            // tomar el valor price de cada item
            Double priceItem = itemRestService.getItemPrice(item);
            // validar que no se pase de ese monto maximo
            if (priceItem != null && (amountTotal + priceItem) < amount){
                // sume a una variable
                amountTotal += priceItem;
                // agregar el item a la lista de respuesta
                itemListResponse.add(item);
            }
        }
        // dar respuesta de los items array y el costo total

        responseCouponMaxToBuy.setItemsIds(itemListResponse);
        responseCouponMaxToBuy.setTotal(amountTotal);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCouponMaxToBuy);
    }
}
