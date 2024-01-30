package citybike.HelsinkiCitybikeBackend.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@CrossOrigin//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller	

public class CommentController {

@Autowired 
private CommentRepository commentRepository;


//1.  ----------LISTAA KAIKKI ASEMAT  REST -------------------------------------------	
@GetMapping(path="/api/comments")
public @ResponseBody Iterable<Comment> getAllComments() {
// This returns a JSON or XML with the users
return commentRepository.findAll();
}


//2. ---------------KOMMENTIN TALLENNUS --------------------------------------------------------------------	

@RequestMapping(value = "/api/comments", method = RequestMethod.POST) 
//kun urliin tehdään post pyyntö, se aktivoi allaolevan:

Comment newComment (@RequestBody Comment newComment) {
	return commentRepository.save(newComment);
}

}




