package citybike.HelsinkiCitybikeBackend.journey;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import citybike.HelsinkiCitybikeBackend.station.StationRepository;

@CrossOrigin
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller
public class JourneySortingController {

	@Autowired
	private JourneyRepository journeyRepository;

	@Autowired
	private StationRepository stationRepository;
	


	
	// SORTING  ------------ tämä pitäisi tehdä järkevämmin	 ----------------------------

	@GetMapping("/journeys/sortedby/newestdeparture")
	  public String sortByDepartureLatest(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	      Page<Journey> page = journeyRepository.findByOrderByDepartureTimeDesc(pageable);
	      model.addAttribute("page", page);
	      model.addAttribute("stations", stationRepository.findAll());
	      model.addAttribute("journey", new Journey()); 
	      return "journeyspage";
	 }
		
	 @GetMapping("/journeys/sortedby/earliestdeparture")
	  public String sortByDepartureErliest(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	      Page<Journey> page = journeyRepository.findByOrderByDepartureTime(pageable);
	      model.addAttribute("page", page);
	      model.addAttribute("stations", stationRepository.findAll());
	      model.addAttribute("journey", new Journey()); 
	      return "journeyspage";
	 } 
	
		@GetMapping("/journeys/sortedby/newestreturn")
		  public String sortByReturnLatest(@PageableDefault(size = 100) Pageable pageable,
		                             Model model) {
		      Page<Journey> page = journeyRepository.findByOrderByDepartureTimeDesc(pageable);
		      model.addAttribute("page", page);
		      model.addAttribute("stations", stationRepository.findAll());
		      model.addAttribute("journey", new Journey()); 
		      return "journeyspage";
		 }
			
		 @GetMapping("/journeys/sortedby/earliestreturn")
		  public String sortByReturnErliest(@PageableDefault(size = 100) Pageable pageable,
		                             Model model) {
		      Page<Journey> page = journeyRepository.findByOrderByDepartureTime(pageable);
		      model.addAttribute("page", page);
		      model.addAttribute("stations", stationRepository.findAll());
		      model.addAttribute("journey", new Journey()); 
		      return "journeyspage";
		 } 
	
	
	
	@GetMapping("/journeys/sortedby/departurestation")
	  public String sortByDepartureStation(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	      Page<Journey> page = journeyRepository.findByOrderByDepartureStationName(pageable);
	      model.addAttribute("page", page);
	      model.addAttribute("stations", stationRepository.findAll());
	      model.addAttribute("journey", new Journey()); 
	      return "journeyspage";
	 }
		
	 @GetMapping("/journeys/sortedby/returnstationname")
	  public String sortByReturnStation(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	      Page<Journey> page = journeyRepository.findByOrderByReturnStationName(pageable);
	      model.addAttribute("page", page);
	      model.addAttribute("stations", stationRepository.findAll());
	      model.addAttribute("journey", new Journey()); 
	      return "journeyspage";
	 } 

	 
		@GetMapping("/journeys/sortedby/longestdistance")
		  public String sortByLongestdistance(@PageableDefault(size = 100) Pageable pageable,
		                             Model model) {
		      Page<Journey> page = journeyRepository.findByOrderByCoveredDistanceDesc(pageable);
		      model.addAttribute("page", page);
		      model.addAttribute("stations", stationRepository.findAll());
		      model.addAttribute("journey", new Journey()); 
		      return "journeyspage";
		 }
			
		 @GetMapping("/journeys/sortedby/shortestdistance")
		  public String sortByShortestdistance(@PageableDefault(size = 100) Pageable pageable,
		                             Model model) {
		      Page<Journey> page = journeyRepository.findByOrderByCoveredDistance(pageable);
		      model.addAttribute("page", page);
		      model.addAttribute("stations", stationRepository.findAll());
		      model.addAttribute("journey", new Journey()); 
		      return "journeyspage";
		 } 
	 
	 
			@GetMapping("/journeys/sortedby/longestduration")
			  public String sortByLongestDuration(@PageableDefault(size = 100) Pageable pageable,
			                             Model model) {
			      Page<Journey> page = journeyRepository.findByOrderByDurationDesc(pageable);
			      model.addAttribute("page", page);
			      model.addAttribute("stations", stationRepository.findAll());
			      model.addAttribute("journey", new Journey()); 
			      return "journeyspage";
			 }
				
			 @GetMapping("/journeys/sortedby/shortestduration")
			  public String sortByShortestDuration(@PageableDefault(size = 100) Pageable pageable,
			                             Model model) {
			      Page<Journey> page = journeyRepository.findByOrderByDuration(pageable);
			      model.addAttribute("page", page);
			      model.addAttribute("stations", stationRepository.findAll());
			      model.addAttribute("journey", new Journey()); 
			      return "journeyspage";
			 } 
	 
	 
	 
	    
}
	
	

