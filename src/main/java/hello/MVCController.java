package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController
{

  // @Override
  // public void addViewControllers(ViewControllerRegistry registry)
  // {
  // registry.addViewController("/result").setViewName("result");
  // }

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

  @RequestMapping(value = "/start", method = RequestMethod.GET)
  public String greetingForm(Model model)
  {
    model.addAttribute("greeting", new Greeting());
    return "greeting_form";
  }

  @RequestMapping(value = "/end", method = RequestMethod.POST)
  public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult)
  {

    if (bindingResult.hasErrors())
    {
      return "greeting_form";
    }

    return "result";
  }

}
