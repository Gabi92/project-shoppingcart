package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.dao;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.PiqTx;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiqTxDao extends CrudRepository<PiqTx, Long> {

    PiqTx findByTxId(Long txId);

    PiqTx findByPiqTxId(String piqTxId);

}