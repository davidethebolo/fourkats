package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

  @RequestMapping("/ciao")
  public String index()
  {
    return "Sucate tutti!";
  }
}