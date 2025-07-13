package lk.hasindu.controller;

import jakarta.servlet.annotation.MultipartConfig;
import lk.hasindu.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    // save customer form data

    //CIDs - Customer ID
    //CNames - Customer Name
    //CAddress - Customer Address

//    @PostMapping
//    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
//        System.out.println("Customer ID: " + customerDTO.getCID());
//        System.out.println("Customer Name: " + customerDTO.getCName());
//        System.out.println("Customer Address: " + customerDTO.getCAddress());
//        return "Customer saved successfully!";
//    }

    // save customer (Query Parameters)

//    @PostMapping(params = {"CID", "CName", "CAddress"})
//    public String updateCustomer(
//            @RequestParam("CID") String CID,
//            @RequestParam("CName") String CName,
//            @RequestParam("CAddress") String CAddress) {
//        System.out.println("Customer ID: " + CID);
//        System.out.println("Customer Name: " + CName);
//        System.out.println("Customer Address: " + CAddress);
//        return "Customer updated successfully!";
//    }

    // save customer (Path Variables)

//    @PostMapping("saveWithPathVariable/{CID}/{CName}/{CAddress}")
//    public String saveCustomer(
//            @PathVariable("CID") String CID,
//            @PathVariable("CName") String CName,
//            @PathVariable("CAddress") String CAddress) {
//        System.out.println("Customer ID: " + CID);
//        System.out.println("Customer Name: " + CName);
//        System.out.println("Customer Address: " + CAddress);
//        return "Customer saved successfully!";
//    }

    // save customer (JSON)
    @PostMapping(path = "/saveWithJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("Customer ID: " + customerDTO.getCID());
        System.out.println("Customer Name: " + customerDTO.getCName());
        System.out.println("Customer Address: " + customerDTO.getCAddress());
        return customerDTO;
    }

    // Return JSON object
    @GetMapping(path = "/getCustomer", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO getCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("C001", "John Doe", "123 Main St");
        System.out.println("Returning customer: " + customerDTO);
        return customerDTO;
    }
}
