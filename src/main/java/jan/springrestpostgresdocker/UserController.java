package jan.springrestpostgresdocker;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Operation(summary = "test")
  @GetMapping("/user/all")
  Iterable<UserModel> all() {
    return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
  UserModel userById(@PathVariable Long id) {
    return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND));
  }

  @PostMapping("/user/save")
  UserModel save(@RequestBody UserModel user) {
    return userRepository.save(user);
  }

}