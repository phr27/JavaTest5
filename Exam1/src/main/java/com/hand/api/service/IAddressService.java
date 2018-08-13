package com.hand.api.service;

import com.hand.domain.entity.Address;

public interface IAddressService {

    Address findByAddress(String address);
}
