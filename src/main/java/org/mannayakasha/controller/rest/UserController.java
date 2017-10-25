package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.User;
import org.mannayakasha.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Rest controller for the {@link org.mannayakasha.entity.User} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity<User> getById(@RequestParam("id") String id) {
        User user = userService.getById(Integer.parseInt(id));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.create(user);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user?id={id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("user")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("user")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        userService.delete(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
