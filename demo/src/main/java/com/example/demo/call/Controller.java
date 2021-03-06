package com.example.demo.call;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {
	
	@RequestMapping(value = "/v2/ivrcall", method = RequestMethod.GET)
    public ResponseEntity<String> ivrcall(){

		CallHandler ch = new CallHandler();
		ch.test();
        if(null != ch)
            return ResponseEntity.ok().body("a");
        else
            return ResponseEntity.badRequest().body("b");
	}

}
