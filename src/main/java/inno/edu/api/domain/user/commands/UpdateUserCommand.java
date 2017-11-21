package inno.edu.api.domain.user.commands;

import inno.edu.api.domain.user.commands.dtos.UpdateUserRequest;
import inno.edu.api.domain.user.commands.mappers.UpdateUserRequestMapper;
import inno.edu.api.domain.user.models.User;
import inno.edu.api.domain.user.queries.GetUserByIdQuery;
import inno.edu.api.domain.user.repositories.UserRepository;
import inno.edu.api.infrastructure.annotations.Command;

import java.util.UUID;

@Command
public class UpdateUserCommand {
    private final UpdateUserRequestMapper updateUserRequestMapper;
    private final UserRepository userRepository;
    private final GetUserByIdQuery getUserByIdQuery;

    public UpdateUserCommand(UpdateUserRequestMapper updateUserRequestMapper, UserRepository userRepository, GetUserByIdQuery getUserByIdQuery) {
        this.updateUserRequestMapper = updateUserRequestMapper;
        this.userRepository = userRepository;
        this.getUserByIdQuery = getUserByIdQuery;
    }

    public User run(UUID id, UpdateUserRequest updateUserRequest) {
        User currentUser = getUserByIdQuery.run(id);
        updateUserRequestMapper.setUser(updateUserRequest, currentUser);
        return userRepository.save(currentUser);
    }
}
