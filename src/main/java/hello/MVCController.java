package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController
{

  @RequestMapping(value = "/fetch_quote_html")
  public String fetchQuoteHtml(
                               @RequestParam(value = "name", required = false, defaultValue = "World") String name,
                               @RequestParam(value = "surname", required = false, defaultValue = "War") String surname,
                               Model model)
  {
    model.addAttribute("name", name);
    model.addAttribute("ciccio", surname);
    return "greeting";
  }

}
