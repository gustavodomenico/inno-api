package inno.edu.api.domain.profile.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMentorProfileRequest {
    @NotNull
    private String description;

    @NotNull
    private BigDecimal rate;
}
