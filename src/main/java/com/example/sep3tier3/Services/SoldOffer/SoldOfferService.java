package com.example.sep3tier3.Services.SoldOffer;

import com.example.sep3tier3.Entities.SaleOffer;
import com.example.sep3tier3.Entities.SoldOffer;
import com.example.sep3tier3.Entities.Wallet;

import java.util.List;

public interface SoldOfferService {

    List<SoldOffer> findAll();

    List<SoldOffer> findSoldOfferByOrderId(long id);

    List<SoldOffer> findSoldOfferBySellerWalletId(long id);

    SoldOffer addSoldOffer(SoldOffer saleOffer);

}
