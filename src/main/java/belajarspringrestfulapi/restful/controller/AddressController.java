package belajarspringrestfulapi.restful.controller;

import belajarspringrestfulapi.restful.entity.User;
import belajarspringrestfulapi.restful.model.AddressResponse;
import belajarspringrestfulapi.restful.model.CreateAddressRequest;
import belajarspringrestfulapi.restful.model.WebResponse;
import belajarspringrestfulapi.restful.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user, @RequestBody CreateAddressRequest request, @PathVariable("contactId") String contactId) {
        request.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }
}
