package citybike.HelsinkiCitybikeBackend.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller

public class StationSortingController {
	@Autowired
	private StationRepository stationRepository;
	

	
	
	 @GetMapping("/stations/sortedby/stationname")
	  public String sortByStation_name(@PageableDefault(size = 100) Pageable pageable,
	                             Model model) {
	 	 Page<Station> page = stationRepository.findByOrderByName(pageable);    
	      model.addAttribute("page", page);
	      model.addAttribute("station", new Station()); // "tyhjä" olio
	      return "stationspage";
	 } 
	
}




