package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import javax.swing.*;

public record UserRecordDto(@NotBlank Spring name, @NotBlank @Email Spring email) {
}
