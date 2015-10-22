package hello;

import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController
{

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/ciao")
  public String index()
  {
    return "Sucate tutti!";
  }

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
  {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @RequestMapping(method = RequestMethod.POST, value = "/greeting2")
  public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name)
  {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));

  }

  @RequestMapping(value = "/fetch_quote")
  public String fetchQuote()
  {

    RestTemplate restTemplate = new RestTemplate();
    Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    String text = "<html><head></head><body><h1> {0} </h1><br/><h2> {1} </h2></body></html>";
    String format = MessageFormat.format(text, quote.getType(), quote.getValue().getQuote());

    return format;

  }

}
