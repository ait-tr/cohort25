package de.ait.ec.dto;

import lombok.Data;

/**
 * 10/2/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class NewLessonDto {
    private String name;
    private String startTime;
    private String finishTime;
    private String dayOfWeek;
}
