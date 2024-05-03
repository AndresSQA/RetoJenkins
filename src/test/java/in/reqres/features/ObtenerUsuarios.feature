Feature: Se desea Obtener la informacion de usuarios mediante servicio rest y paginacion

  @get
  Scenario Outline: Obtener usuarios
    Given El usuario consume el endpoint y la pagina <pagina>
    When se obtenga el codigo y cuerpo de la respuesta
    Then podra ver los datos de usuarios en la pagina enviada y el <codigo> con el status

    Examples:
      | pagina | codigo |
      | 2      | 200    |