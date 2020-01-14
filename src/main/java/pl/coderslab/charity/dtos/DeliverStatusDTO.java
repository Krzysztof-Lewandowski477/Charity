package pl.coderslab.charity.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DeliverStatusDTO {

    private Long id;
    private String status;
    private LocalDateTime deliverTime;
}
