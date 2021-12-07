package by.gsu.pms.idz_12.repositories;

import by.gsu.pms.idz_12.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findOneByName(String name);
}


