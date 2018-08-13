package com.hand.api.service.impl;

import com.hand.api.service.IAddressService;
import com.hand.domain.entity.Address;
import com.hand.infra.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    public Address findByAddress(String address) {
        return addressMapper.selectByAddress(address);
    }
}
