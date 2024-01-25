package com.springdemo.mvc.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @NotNull()
    @Size(min=1, message = "is required!")
    private String firstName;
    @NotNull()
    @Size(min = 1, message = "is required!")
    private String lastName;
    @Min(0)
    @Max(10)
    @NotNull
    private Integer freePass;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
