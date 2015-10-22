package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Greeting
{
  @Min(18)
  private Long id;
  @NotNull
  @Size(min = 2, max = 30)
  private String content;

  public Greeting(long id, String content)
  {
    this.id = id;
    this.content = content;
  }

  public Greeting()
  {
  }

  public Long getId()
  {
    return id;
  }

  public String getContent()
  {
    return content;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setContent(String content)
  {
    this.content = content;
  }
}
