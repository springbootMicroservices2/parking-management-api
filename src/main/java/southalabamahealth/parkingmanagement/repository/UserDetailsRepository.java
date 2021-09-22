package southalabamahealth.parkingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import southalabamahealth.parkingmanagement.entity.UserDetails;

@org.springframework.stereotype.Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByContactNumber(String contactNumber);
}
