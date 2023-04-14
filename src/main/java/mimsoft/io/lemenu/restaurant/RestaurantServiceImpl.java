package mimsoft.io.lemenu.restaurant;

import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<RestaurantDto> getAll() {
        return restaurantRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto get(Long id) {
        Restaurant restaurant = restaurantRepository.findByIdAndByDeletedFalse(id);
        if (restaurant!=null) {
            return toDto(restaurant);
        } else {
            return null;
        }
    }

    @Override
    public boolean save(RestaurantDto restaurantDto) {
        restaurantRepository.save(fromDto(restaurantDto));
        return true;
    }

    @Override
    public boolean update(RestaurantDto restaurantDto) {
        Restaurant restaurantOptional = restaurantRepository.findByIdAndByDeletedFalse(restaurantDto.getId());
        if (restaurantOptional!=null) {
            restaurantRepository.save(fromDto(restaurantDto));
            return true;
        } else
            return false;
    }

    @Override
    public boolean delete(Long id) {
        Restaurant restaurant = restaurantRepository.findByIdAndByDeletedFalse(id);
        if (restaurant!=null) {
            restaurant.setDeleted(true);
            restaurantRepository.save(restaurant);
        }
        return true;
    }

    private RestaurantDto toDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(
                        new TextModel(
                                restaurant.getNameUz(),
                                restaurant.getNameRu(),
                                restaurant.getNameEng()
                        )
                )
                .logo(restaurant.getLogo())
                .domain(restaurant.getDomain())
                .build();
    }

    private Restaurant fromDto(RestaurantDto restaurantDto) {
        return Restaurant.builder()
                .id(restaurantDto.getId())
                .nameUz(restaurantDto.getName().getUz())
                .nameRu(restaurantDto.getName().getRu())
                .nameEng(restaurantDto.getName().getEng())
                .logo(restaurantDto.getLogo())
                .domain(restaurantDto.getDomain())
                .build();
    }
}
