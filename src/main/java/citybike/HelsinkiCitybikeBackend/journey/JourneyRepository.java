package citybike.HelsinkiCitybikeBackend.journey;



import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import jakarta.transaction.Transactional;



@Transactional
public interface JourneyRepository  extends PagingAndSortingRepository<Journey, Integer> {

	 //  List<Journey> findByOrderByIdDesc();
	//   Page<Journey> findAll(Pageable pageable);  
	
		Page<Journey> findByOrderByIdDesc(Pageable pageable);
	    Page<Journey> findByOrderById(Pageable pageable);
	    
	    Page<Journey> findByOrderByDepartureTimeDesc(Pageable pageable);
	    Page<Journey> findByOrderByDepartureTime(Pageable pageable);
	    	    
	    Page<Journey> findByOrderByDepartureStationNameDesc(Pageable pageable);
	    Page<Journey> findByOrderByDepartureStationName(Pageable pageable);
	    
	    Page<Journey> findByOrderByReturnStationNameDesc(Pageable pageable);
	    Page<Journey> findByOrderByReturnStationName(Pageable pageable);
	    
	    Page<Journey> findByOrderByCoveredDistanceDesc(Pageable pageable);
	    Page<Journey> findByOrderByCoveredDistance(Pageable pageable);
	    
	    Page<Journey> findByOrderByDurationDesc(Pageable pageable);
	    Page<Journey> findByOrderByDuration(Pageable pageable);
	    
		Iterable<Journey> findAll();
		
		void save(Journey journey);
		
		Optional<Journey> findById(int id);
		
		void delete(Journey journey);

	

		
}
