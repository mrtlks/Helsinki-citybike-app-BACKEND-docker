package citybike.HelsinkiCitybikeBackend.station;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;



public interface StationRepository extends PagingAndSortingRepository<Station, Integer> {

	List<Station> findByOrderByFidDesc();

	// Station findByName(String name);


	Page<Station> findByOrderByName(Pageable pageable);

	Page<Station> findByOrderByNameDesc(Pageable pageable);

	Page<Station> findByOrderById(Pageable pageable);

	Page<Station> findByOrderByFidDesc(Pageable pageable);

	Page<Station> findByOrderByIdDesc(Pageable pageable);

	Iterable<Station> findAll();

	void save(Station station);
	
	Optional<Station> findById(int id);

	void delete(Station station);

	Station findByName(String departureStationName);

	

	

	

}
