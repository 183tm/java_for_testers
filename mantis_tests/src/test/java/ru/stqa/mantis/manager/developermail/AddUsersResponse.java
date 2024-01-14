package ru.stqa.mantis.manager.developermail;

import ru.stqa.mantis.model.DeveloperMailUser;

public record AddUsersResponse(Boolean succes, Object errors, DeveloperMailUser result) {
}
