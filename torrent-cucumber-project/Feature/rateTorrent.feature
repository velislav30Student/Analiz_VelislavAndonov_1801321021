Feature: Оценяване на торент

Scenario: Оценяване на торент при нелогнат потребител
    Given Потребителят отваря страницата на торент(Оценяване на торент)
    When Потребителят не е влязъл в профила си(Оценяване на торент)
    Then Вижда съобщение(Оценяване на торент) "Влезте в профила си или се регистрирайте"

  Scenario: Оценяване на торент
    Given Потребителят отваря страницата на торент(Оценяване на торент)
    When Потребителят "name" е влязъл в профила си(Оценяване на торент)
    And Торента има текуща оценка 5
    And Потребителя оцени торента с оценка 4
    Then На потребителя е показана нова оценка на торента "4.75"

  Scenario: Промяна на Оценка на торент
    Given Потребителят отваря страницата на торент(Оценяване на торент)
    When Потребителят "name2" е влязъл в профила си(Оценяване на торент)
    And Торента има текуща оценка 5
    And Потребителя променя оценката си на торента с оценка 1
    Then На потребителя е показана нова оценка на торента "3.67"
    
  Scenario: Премахване на Оценка на торент
    Given Потребителят отваря страницата на торент(Оценяване на торент)
    When Потребителят "name3" е влязъл в профила си(Оценяване на торент)
    And Торента има текуща оценка 5
    And Потребителя променя оценката си на торента с оценка 0
    Then На потребителя е показана нова оценка на торента "5.0"