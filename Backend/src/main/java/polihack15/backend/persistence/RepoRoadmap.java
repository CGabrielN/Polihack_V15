package polihack15.backend.persistence;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import polihack15.backend.model.Roadmap;

import java.util.List;

@Repository
public interface RepoRoadmap extends JpaRepository<Roadmap, Long> {

    @NotNull
    @Query("SELECT r FROM Roadmap r WHERE r.domain = :domain and r.price > 0")
    List<Roadmap> findPayedByDomain(@NotNull String domain);

    @NotNull
    @Query("SELECT r FROM Roadmap r WHERE r.domain = :domain and r.price = 0")
    List<Roadmap> findFreeByDomain(@NotNull String domain);

    @NotNull
    @Query("SELECT r FROM Roadmap r WHERE r.company = :company and r.price > 0")
    List<Roadmap> findPayedByCompany(@NotNull String company);

    @NotNull
    @Query("SELECT r FROM Roadmap r WHERE r.company = :company and r.price = 0")
    List<Roadmap> findFreeByCompany(@NotNull String company);

    @Query("SELECT r FROM Roadmap r inner join Company c on r.company.id = c.id and c.name = :company")
    List<Roadmap> findAllByCompany(@NotNull String company);

    @Query("Select r from Roadmap r where r.domain LIKE %:domain%")
    List<Roadmap> findAllByDomain(@NotNull String domain);

    @Query("SELECT r FROM Roadmap r WHERE r.domain like %:domain% and r.price = 0")
    List<Roadmap> findFree(@NotNull String domain);

    @Query("SELECT r FROM Roadmap r WHERE r.domain like %:domain% and r.price > 0")
    List<Roadmap> findPayed(@NotNull String domain);

    @Query("SELECT r FROM Roadmap r inner join User u on r.id = u.roadmap.id where u.id = :id_user")
    Roadmap findRoadmapForUser(@NotNull Long id_user);
}
