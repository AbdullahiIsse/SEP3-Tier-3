package com.example.sep3tier3.Controller;

import com.example.sep3tier3.Entities.CreditCard;
import com.example.sep3tier3.Entities.User;
import com.example.sep3tier3.Entities.Wallet;
import com.example.sep3tier3.Handler.SaveInfo;
import com.example.sep3tier3.Services.Payment.CreditCardService;
import com.example.sep3tier3.Services.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")

public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @Autowired
    WalletService walletService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<CreditCard>getAllPayments(){

        return creditCardService.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addPayment(@RequestBody CreditCard payment){
        CreditCard creditCard = creditCardService.addPayment(payment);
        User user = SaveInfo.getInstance().getUser();
        Wallet wallet = walletService.addWallet(new Wallet(0,creditCard.getId(),user.getId()));

        return creditCard;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard getPaymentByUserId(@PathVariable("id") long id){

        return creditCardService.findPaymentById(id);
    }


    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard getPaymentByName(@RequestParam String name) throws Exception {


        CreditCard paymentByName = creditCardService.findPaymentByName(name);
        if (paymentByName == null){

            throw new Exception("name does not exist");

        }else{

            return paymentByName;
        }



    }









}