package mimsoft.io.lemenu.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Product management APIs")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "There are no products", content = {
                    @Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @Operation(
            summary = "Get a product by Id",
            description = "Get a product object by specifying its id. The response is product object with id, title, description and published status.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Product.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        ProductDto productDto = productService.get(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else
            return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/product")
    public ResponseEntity<Void> add(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Update a product by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @SneakyThrows
    @PutMapping("/product")
    public ResponseEntity<Void> update(@RequestBody ProductDto productDto) {
        boolean status = productService.update(productDto);
        if (status) {
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Delete a product by Id")
    @ApiResponses({@ApiResponse(responseCode = "204", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean status = productService.delete(id);
        if (status) {
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.noContent().build();
    }
}
