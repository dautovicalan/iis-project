package com.alan.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EntitySearch {

    public String searchNbaTeams(@WebParam(name = "inputTerm") String inputTerm);
}
