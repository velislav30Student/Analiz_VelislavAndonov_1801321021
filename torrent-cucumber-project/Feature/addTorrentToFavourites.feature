Feature: Добавяне на торент в любими

	Scenario: Добавяне на торент в любими при нелогнат потребител
    Given Потребителят отваря страницата на торент
    When Потребителят не е влязъл в профила си(Добавяна на торенти в любими)
    Then Вижда съобщение(Добавяна на торенти в любими) "Влезте в профила си или се регистрирайте"

  Scenario: Добавяне на торент в любими
    Given Потребителят отваря страницата на торент
    When Потребителят е влязъл в профила си(Добавяна на торенти в любими)
    And Торентът не е в любимите торенти на потребителя
    And Кликне върху бутона за добавяне в любими
    Then Вижда съобщение(Добавяна на торенти в любими) "Торентът е добавен в списъка с любими торенти"
    
  Scenario: Добавяне на торент в любими когато вече е добавен в любими
    Given Потребителят отваря страницата на торент
    When Потребителят е влязъл в профила си(Добавяна на торенти в любими)
    And Торентът е в любимите торенти на потребителя
    And Кликне върху бутона за добавяне в любими
    Then Вижда съобщение(Добавяна на торенти в любими) "Торентът е премахнат от списъка с любими торенти"