package mimsoft.io.lemenu.restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAll();
    RestaurantDto get(Long id);
    boolean save(RestaurantDto restaurantDto);
    boolean update(RestaurantDto restaurantDto);
    boolean delete(Long id);
}
