package citybike.HelsinkiCitybikeBackend.journey;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import citybike.HelsinkiCitybikeBackend.station.Station;
import citybike.HelsinkiCitybikeBackend.station.StationRepository;

@CrossOrigin
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller
public class JourneyController {

	@Autowired
	private JourneyRepository journeyRepository;

	@Autowired
	private StationRepository stationRepository;
	


	
//  REST -------------------------------------------	

//1. MATKOJEN LISTAUS -----------------	

	

	@GetMapping(path = "/api/alljourneys")
	public @ResponseBody Iterable<Journey> getAllJourneys() {
		// This returns a JSON or XML with the users
		return journeyRepository.findAll();
	}


	@GetMapping(path = "/api/journeys")
	public @ResponseBody Page<Journey> journeysApiPageable(Pageable pageable) {
		// This returns a JSON or XML with the users
		return journeyRepository.findAll(pageable);
	}
	
	
// THYMELEAF --------------------------------------------------------------------------	

	
	//1. MATKOJEN LISTAUS -----------------	
	
	
	@GetMapping("/")	//etusivu (sisältää nyt saman kuin "/journeys")
	 public String startergetJourneys(@PageableDefault(size = 100) Pageable pageable,
             Model model) {
			Page<Journey> page = journeyRepository.findByOrderByIdDesc(pageable);			
			model.addAttribute("page", page);
			model.addAttribute("stations", stationRepository.findAll());
			model.addAttribute("journey", new Journey()); // "tyhjä" olio
			return "journeyspage";
	}
	
	 @GetMapping("/journeys")
	  public String getJourneys(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	      Page<Journey> page = journeyRepository.findByOrderByIdDesc(pageable);

	      model.addAttribute("page", page);
	      model.addAttribute("stations", stationRepository.findAll());
	      model.addAttribute("journey", new Journey()); // "tyhjä" olio
	      return "journeyspage";
	 }
	
	


// 2.MATKAN TALLENTAMINEN -----------------
	@RequestMapping(value = "/savejourney", method = RequestMethod.POST)
	public String saveJourney(Journey journey) {
	
		String departureStationName = journey.getDepartureStationName();
		String returnStationName = journey.getReturnStationName();
		
	//	System.out.print("-------- Lähtöasema: " + departureStationName);
	//	System.out.print("-------- Paluuasema: " + returnStationName);
		

		Station dstation = stationRepository.findByName(departureStationName);
		Station rstation = stationRepository.findByName(returnStationName);

		int dstationid = dstation.getId();
		int rstationid = rstation.getId();
		journey.setDepartureStationId(dstationid);
		journey.setReturnStationId(rstationid);
		
		journey.setRemovable(true);
		journey.setEditable(true);
		journeyRepository.save(journey);

	
		return "redirect:journeys";
	}

//3.  MATKAN POISTAMINEN jos matka on "removable"--------alustavasti vain sovelluksesta lisätyt matkat on mahdollista poistaa------------------------------------------------------------	
	@RequestMapping(value = "delete/journey/{id}", method = RequestMethod.GET)
	public String deleteJourneyifremovable(@PathVariable("id") int id) {
		System.out.print(" testi miten id näkyy  ----- "+id);
		Journey journey = journeyRepository.findById(id).get();
		if (journey.getRemovable()) {
			journeyRepository.delete(journeyRepository.findById(id).get());
		} else {
			System.out.print("not removable");
			return "redirect:/journeys";
		}
		return "redirect:/journeys";
	}



// 4. MATKAN MUOKKAAMINEN jos matka on editable  --------alustavasti vain sovelluksesta lisätyt matkat on mahdollista muokata--------------------

	@RequestMapping(value = "/edit/{id}/journey", method = RequestMethod.GET)
	public String editJourneyifEditable(@PathVariable("id") int id, Model model) {
		Journey journey = journeyRepository.findById(id).get();
		System.out.print("-------- aseman id" + id);
		if (journey.getEditable()) {
			model.addAttribute("journey", journey);
			model.addAttribute("stations", stationRepository.findAll());
		} else {
			System.out.print("not editable");
			return "redirect:/journeys";
			
		}
		return "editjourney";
	}

	
}
