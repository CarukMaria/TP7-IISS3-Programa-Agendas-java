Feature: Gestión de eventos en agenda

  Scenario: Buscar evento existente
    Given una agenda con eventos cargados
    When busco el evento "Parcial"
    Then el evento debe ser encontrado
