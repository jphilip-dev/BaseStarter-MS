package com.jphilips.auth.service;

import com.jphilip.shared.domain.exception.errorcode.AuthErrorCode;
import com.jphilips.auth.entity.User;
import com.jphilips.auth.exception.custom.EmailAlreadyExistException;
import com.jphilips.auth.exception.custom.OwnerMismatchException;
import com.jphilips.auth.exception.custom.UserInactiveException;
import com.jphilips.auth.exception.custom.UserNotFoundException;
import com.jphilips.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthManager {

    private final UserRepository userRepository;

    // === Core User Operations ===

    // Save or update a user
    public User saveUser(User user) {
        log.info("Saving user - ID: {}, Email: {}",
                user.getId() == null ? "NEW" : user.getId(),
                user.getEmail());
        return userRepository.save(user);
    }

    // Delete a user from the database
    public void deleteUser(User user) {
        log.info("Deleting user - ID: {}, Email: {}", user.getId(), user.getEmail());
        userRepository.delete(user);
    }

    // === User Validation ===

    // Validate user by ID
    public User validateUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(AuthErrorCode.USER_NOT_FOUND));
    }

    // Validate user by email
    public User validateUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(AuthErrorCode.USER_NOT_FOUND));
    }

    // Check if email is available
    public void checkUserEmailAvailability(String email) {
        if (userRepository.findByEmail(email.toLowerCase()).isPresent()) {
            throw new EmailAlreadyExistException(AuthErrorCode.EMAIL_EXISTS);
        }
    }

    // Check if the authenticated user is the same as the target user
    public void checkUserOwnership(Long headerUserId, Long userId) {
        if (!Objects.equals(headerUserId, userId)) {
            throw new OwnerMismatchException(AuthErrorCode.OWNERSHIP_MISMATCH);
        }
    }

    // Validate that the user is active
    public void validateUserStatus(User user) {
        if (!user.getIsActive()) {
            throw new UserInactiveException(AuthErrorCode.USER_INACTIVE);
        }
    }

    // === User Status Management ===

    // Activate the user's status.
    public User activateUserStatus(User user) {
        user.setIsActive(true);
        log.info("Activating user - ID: {}", user.getId());
        return saveUser(user);
    }

    // Deactivate the user's status.
    public User deactivateUserStatus(User user) {
        user.setIsActive(false);
        log.info("Deactivating user - ID: {}", user.getId());
        return saveUser(user);
    }
}
