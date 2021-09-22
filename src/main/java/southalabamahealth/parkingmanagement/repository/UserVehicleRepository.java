package southalabamahealth.parkingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import southalabamahealth.parkingmanagement.entity.UserVehicleEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVehicleRepository extends JpaRepository<UserVehicleEntity, String> {

    List<UserVehicleEntity> findVehicleByUserId();

     Optional<UserVehicleEntity> findByPlateId(long parseLong);

    void deleteByPlateId(long parseLong);
}
