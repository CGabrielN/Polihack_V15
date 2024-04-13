package polihack15.backend.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polihack15.backend.business.ServiceRoadmap;
import polihack15.backend.model.Roadmap;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerRoadmap {
    @Autowired
    private ServiceRoadmap serviceRoadmap;

    @GetMapping("/roadmapsP/{domain}")
    public ResponseEntity<List<Roadmap>> getPaidRoadmapsByDomain(@PathVariable String domain) {
        return ResponseEntity.ok(serviceRoadmap.getPaidRoadmapsByDomain(domain));
    }

    @GetMapping("/roadmapsF/{domain}")
    public ResponseEntity<List<Roadmap>> getFreeRoadmapsByDomain(@PathVariable String domain) {
        return ResponseEntity.ok(serviceRoadmap.getFreeRoadmapsByDomain(domain));
    }
    @GetMapping("/roadmapsP/{company}")
    public ResponseEntity<List<Roadmap>> getPaidRoadmapsByCompany(@PathVariable String company) {
        return ResponseEntity.ok(serviceRoadmap.getPaidRoadmapsByCompany(company));
    }

    @GetMapping("/roadmapsF/{company}")
    public ResponseEntity<List<Roadmap>> getFreeRoadmapsByCompany(@PathVariable String company) {
        return ResponseEntity.ok(serviceRoadmap.getFreeRoadmapsByCompany(company));
    }

    @GetMapping("/roadmaps/getAll")
    public ResponseEntity<List<Roadmap>> getAllRoadmaps() {
        return ResponseEntity.ok(serviceRoadmap.getAllRoadmaps());
    }

    @GetMapping("/roadmaps/getAllByCompany/{company}")
    public ResponseEntity<List<Roadmap>> getAllRoadmapsByCompany(@PathVariable String company) {
        return ResponseEntity.ok(serviceRoadmap.getAllRoadmapsByCompany(company));
    }

    @GetMapping("/roadmaps/getAllByDomain/{domain}")
    public ResponseEntity<List<Roadmap>> getAllRoadmapsByDomain(@PathVariable String domain) {
        return ResponseEntity.ok(serviceRoadmap.getAllRoadmapsByDomain(domain));
    }
}
