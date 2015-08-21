
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

        // get("/", (request, response) -> {
        //   HashMap<String, Object> model = new HashMap<String, Object>();
        //   model.put("template", "templates/index.vtl");
        //   return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("words", Word.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/words/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/word-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/words", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     String userWord = request.queryParams("userWord");
     Word newWord = new Word(userWord);
     model.put("word", newWord);
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


    get("/words/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
    model.put("template", "templates/word.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words/:id/definitions/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
     model.put("template", "templates/create-a-word-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


 //   post("/contacts", (request, response) -> {
 //     HashMap<String, Object> model = new HashMap<String, Object>();
 //     AddressBook addressbook = AddressBook.find(Integer.parseInt(request.queryParams("addressbookId")));
 //     String name = request.queryParams("name");
 //     String home = request.queryParams("home");
 //     String cell = request.queryParams("cell");
 //     String email = request.queryParams("email");
 //     Contact newContact = new Contact(name, home, cell, email);
 //     addressbook.addContact(newContact);
 //     model.put("addressbook", addressbook);
 //     model.put("template", "templates/addressbook.vtl");
 //     return new ModelAndView(model, layout);
 //   }, new VelocityTemplateEngine());
 //
 //   get("/contact/:id", (request, response) -> {
 //   HashMap<String, Object> model = new HashMap<String, Object>();
 //   Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
 //   model.put("contact", contact);
 //   model.put("template", "templates/contact.vtl");
 //   return new ModelAndView(model, layout);
 // }, new VelocityTemplateEngine());
}
}
