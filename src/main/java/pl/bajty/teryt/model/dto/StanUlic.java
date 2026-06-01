package pl.bajty.teryt.model.dto;

import java.time.LocalDate;

/**
 * Reprezentuje informację o dacie stanu danych w katalogu ULIC.
 *
 * @param data Data stanu danych.
 */
public record StanUlic(LocalDate data) {
}
