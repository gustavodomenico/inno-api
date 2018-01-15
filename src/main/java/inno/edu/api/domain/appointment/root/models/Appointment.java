package inno.edu.api.domain.appointment.root.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    private UUID id;

    private UUID mentorProfileId;
    private UUID menteeProfileId;

    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;

    private String description;
    private BigDecimal fee;

    @Enumerated
    private AppointmentStatus status;

    private String reason;
}