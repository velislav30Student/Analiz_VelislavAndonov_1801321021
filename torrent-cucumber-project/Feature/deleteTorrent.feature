Feature: Изтриване на торент

  Scenario: Изтриване на торент при нелогнат потребител
    Given Потребителят отваря страницата на торент(Изтриване на торент)
    When Потребителя не е влязъл в профила си(Изтриване на торент) 
    Then Вижда съобщение(Изтриване на торент) "Влезте с акаунт, притежаващ административни права"
    
  Scenario: Изтриване на торент при притежаване на административни права
  	Given Потребителят отваря страницата на торент(Изтриване на торент)
    When Потребителят е влязъл в профила си(Изтриване на торент)
    And Потребителя притежава административни права
    And Потребителя кликва върху бутона за изтриване
    Then Вижда съобщение(Изтриване на торент) "Торентът е изтрит"
    
  Scenario: Изтриване на торент при липса на административни права
  	Given Потребителят отваря страницата на торент(Изтриване на торент)
    When Потребителят е влязъл в профила си(Изтриване на торент)
    And Потребителя не притежава административни права
    And Потребителя кликва върху бутона за изтриване
    Then Вижда съобщение(Изтриване на торент) "Нямате необходимите права"