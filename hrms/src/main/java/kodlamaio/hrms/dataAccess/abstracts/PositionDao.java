package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
	boolean existsByPositionName(String positionName);
	
	List<Position> findByJobPostings_jobPostingId(int jobPostingId);
	
	Position getBypositionId(int positionId);
}
