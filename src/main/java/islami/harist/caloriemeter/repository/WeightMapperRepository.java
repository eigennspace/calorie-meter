package islami.harist.caloriemeter.repository;

import islami.harist.caloriemeter.model.WeightMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightMapperRepository extends JpaRepository<WeightMapper, Long> {
}