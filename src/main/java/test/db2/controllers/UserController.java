package test.db2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.db2.domain.User;

@RestController
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@RequestMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
		log.info("health API invoked");
        return new ResponseEntity<String>("Service UP", HttpStatus.OK);
    }
	
    @RequestMapping("/testdb2")
    public @ResponseBody ResponseEntity<String> example() {
    	log.info("DB2 test API invoked");
        List<String> list = new ArrayList<>();
        list.add("Table data...");
        jdbcTemplate.query("SELECT * FROM TEST_DB.TEST_TABLE", new Object[]{},
                (rs,rowNum) -> new User(rs.getInt("id"), rs.getString("name")))
                .forEach(thing -> list.add(thing.toString()));
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

}
