package ma.enset.bdccensetspringmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @Id @GeneratedValue // Use @GeneratedValue to auto-generate the ID
    private Long id;
    @NotEmpty // Use @NotEmpty to ensure the name is not empty
    @Size(min = 2, max = 50) // Use @Size to enforce a minimum and maximum length for the name
    private String name;
    @Min(0) // Use @Min to ensure the price is not negative
    private double price;
    @Min(0)
    private double quantity;
    private String description;
    @Min(1)
    private int stocked;
    private boolean selected;
}
