//Test for api/allstations endpoint. 
//Tests if the first station in the array is the same as expected.



package citybike.HelsinkiCitybikeBackend;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import citybike.HelsinkiCitybikeBackend.station.Station;
import citybike.HelsinkiCitybikeBackend.station.StationController;
import citybike.HelsinkiCitybikeBackend.station.StationRepository;



@WebMvcTest(StationController.class)
public class StationEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StationRepository stationRepository;

    @Test
    public void testGetLastStationByName() throws Exception {
        Station station1 = new Station();
        station1.setId(1);
        station1.setFid(111);
        station1.setName("Kaivopuisto");
        station1.setNimi("Kaivopuisto");
        station1.setNamn("Brunnsparken");
        station1.setAddress("Meritori 1");
        station1.setAdress("Havstorget 1");
        station1.setStad("");
        station1.setOperaattor("");
        station1.setKapasiteet("30");
        station1.setcity("");
        station1.setX("24.9502114714031");
        station1.setY("60.155369615074");
        station1.setIsremovable(false);
        station1.setEditable(false);

        // Create more stations if needed

        List<Station> allStations = Arrays.asList(station1); // Add more stations as needed

        given(stationRepository.findAll()).willReturn(allStations);

        mockMvc.perform(get("/api/allstations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Kaivopuisto"))); // Asserts the first item in the array
    }
}
