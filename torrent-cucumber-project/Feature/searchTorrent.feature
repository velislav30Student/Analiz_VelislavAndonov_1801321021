Feature: Търсене на торенти

  Scenario: Теглене на торент при нелогнат потребител
    Given Потребителя орваря страница на каталог
    When Потребителят не е влязъл в профила си(Търсене на торенти)
    Then Вижда съобщение(Търсене на торенти) "Влезте в профила си или се регистрирайте"

  Scenario Outline: Търсене на торенти
    Given Потребителя орваря страница на каталог
    When Потребителят е влязъл в профила си(Търсене на торенти)
    And Въвежда стойност за търсене "<searchText>"
    And Избере тип за търсене "<type1>"
    And Избере тип за търсене "<type2>"
    And Избере жанр за търсене "<genre1>"
    And Избере жанр за търсене "<genre2>"
    And Натиска върху бутона за търсене
    Then Вижда списък с торенти "<torrentList>"

    Examples: 
      | searchText  | type1 | type2  | genre1  | genre2 | torrentList  |
      ||||||Skyrim - PC, Skyrim - XBox, Skyrim - PS4, RimWorld, Warcraft|
      | rim |||||Skyrim - PC, Skyrim - XBox, Skyrim - PS4, RimWorld|
      | rim |PC||||Skyrim - PC, RimWorld|
      | rim |PC|XBox|||Skyrim - PC, Skyrim - XBox, RimWorld|
      | rim |||Strategy||RimWorld|
      ||||Strategy||RimWorld, Warcraft|
      | craft |||||Warcraft|
			||||Strategy|Multiplayer|Warcraft|
			| Skyrim |||||Skyrim - PC, Skyrim - XBox, Skyrim - PS4|