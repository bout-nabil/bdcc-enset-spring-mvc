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
    @Id @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
    @Min(0)
    private double price;
    @Min(0)
    private double quantity;
    private String description;
    @Min(0)
    private int stocked;
    private boolean selected;

}
