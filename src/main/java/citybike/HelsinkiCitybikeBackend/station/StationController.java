package citybike.HelsinkiCitybikeBackend.station;

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



@CrossOrigin
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller
public class StationController {

	@Autowired
	private StationRepository stationRepository;
	
//mock test (TestingWebApplivationTest)
	
	@RequestMapping("/test")
	public @ResponseBody String greeting() {
		return "This is a test.";
	}
	


// REST -----------------------------------------------------------------------------

// 1. ASEMIEN LISTAUS -----------------	

	@GetMapping(path = "/api/allstations")
	public @ResponseBody Iterable<Station> getAllStations() {
		return stationRepository.findAll();
	}

	
	@GetMapping(path = "/api/stations")
	public @ResponseBody Page<Station> journeysApiPageable(Pageable pageable) {
		// This returns a JSON or XML with the users
		return stationRepository.findAll(pageable);
	}
	
	
// THYMELEAF --------------------------------------------------------------------------	

//1. ASEMIEN LISTAUS-----------------	

	@RequestMapping(value = "/stations")
	public String getStations(@PageableDefault(size = 100) Pageable pageable,
            Model model)  {
		Page<Station> page = stationRepository.findByOrderByIdDesc(pageable);

		model.addAttribute("page", page);
		model.addAttribute("station", new Station()); // "tyhjä" olio
		return "stationspage";
	}

// 2.  ASEMAN TALLENTAMINEN -----------------

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStation(Station station) {

		// tässä kaikki tiedot joita käyttäjä ei ole antanut
		station.setNimi(station.getName());
		station.setNamn(station.getName());
		station.setAdress(station.getAddress());
		station.setStad(station.getCity());
		station.setIsremovable(true);
		station.setEditable(true);
		stationRepository.save(station);

	
		return "redirect:stations";
	}

//3. ASEMAN POISTAMINEN Jos asema on "removable"------------alustavasti vain sovelluksesta lisättyjä asemia voi poistaa ja muokata--------------------------------------------------------	
	@RequestMapping(value = "delete/station/{id}", method = RequestMethod.GET)
	public String deleteStationifremovable(@PathVariable("id") int id) {
		Station station = stationRepository.findById(id).get();
		if (station.getIsremovable()) {
			stationRepository.delete(stationRepository.findById(id).get());
		} else {
			System.out.print("not removable");
		}
		return "redirect:/stations";
	}



// 4.ASEMAN MUOKKAAMINEN, jos asema on editable  ------------alustavasti vain sovelluksesta lisättyjä asemia voi poistaa ja muokata-----------------

	@RequestMapping(value = "/edit/{id}/station", method = RequestMethod.GET)
	public String editStationifEditable(@PathVariable("id") int id, Model model) {

		Station station = stationRepository.findById(id).get();
		System.out.print("-------- aseman id" + id);
		if (station.getEditable()) {
			model.addAttribute("station", station);
		} else {
			System.out.print("not editable");
			return "redirect:/stations";
		}
		return "editstation";
	}
}

