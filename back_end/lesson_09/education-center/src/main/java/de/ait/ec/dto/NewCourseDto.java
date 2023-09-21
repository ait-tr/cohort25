package de.ait.ec.dto;

import lombok.Data;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class NewCourseDto {

    private String title;
    private String description;
    private String beginDate;
    private String endDate;
    private Double price;
}
