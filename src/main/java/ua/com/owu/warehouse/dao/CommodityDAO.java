package ua.com.owu.warehouse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.warehouse.models.Commodity;

public interface CommodityDAO extends JpaRepository<Commodity, Integer> {
}
