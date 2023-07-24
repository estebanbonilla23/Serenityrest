package Models.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
}
