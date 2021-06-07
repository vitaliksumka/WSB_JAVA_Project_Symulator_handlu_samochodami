## Autohandel 

1. Program w formie gry tekstowej symulującej prace właściciela komisu samochodowego.

2. Zaczynasz posiadając określoną ilość gotówki, nie posiadasz żadnych samochodów, ale masz dostęp do bazy kilkunastu aut, które możesz kupić. Baza aut do kupienia powinna być generowana losowo. Możesz przygotować wcześniej większą bazę pojazdów, z których część będzie losowo wybierana, lub napisać generator pojazdów. Baza jest uzupełniana nowymi samochodami po każdym zakupie.
Każde auto ma określoną:
  - wartość, 
  - markę, 
  - przebieg, 
  - kolor,
  - segment (premium/standard/budget)
  - i zestaw 5 elementów, które mogą być sprawne lub wymagać naprawy.

3. Naprawa każdego z elementów kosztuje, ale też podnosi wartość samochodu. 
	- Hamulce - podnoszą wartość auta o 10%
	- Zawieszenie - podnosi wartość auta o 20%
	- Silnik - podnosi wartość auta o 100%
	- Karoseria - podnosi wartość auta o 50%
	- Skrzynia biegów - 50%

4. Dodatkowo, część samochodów to samochody dostawcze dla których istotny jest rozmiar przestrzeni ładunkowej.

5. Naprawę każdego z elementów możesz zlecić 3 różnym mechanikom. 
	- Janusz - ma najdroższe ceny ale 100% gwarancję
	- Marian - bierze zdecydowanie mniej niż Janusz, ale masz 10% szans, że nie uda mu się naprawić samochodu i konieczna będzie interwencja Janusza
	- Adrian - jest najtańszy, ale masz 20% szans, że nie uda mu się naprawić i 2% szans, że zepsuje coś innego podczas naprawy

6. Koszty napraw powinny zależeć od marki pojazdu i części, która ma zostać naprawiona.
	
7. Dodatkowo każdy samochód musisz umyć i zapłacić 2% podatku od wartości przy zakupie i przy sprzedaży.

8. W grze dostępna jest baza potencjalnych klientów. Początkowo jest to kilka osób, ale możesz wydawać pieniądze na kampanię marketingową, aby powiększyć ich ilość. Wykonanie jednej udanej transakcji generuje 2 potencjalnych klientów bez dodatkowych wydatków. Ogłoszenie w lokalnej gazecie powoduje dopływ losowej grupy kilku nowych klientów, ale kosztuje. Możesz też zainwestować w reklamę w internecie, która jest tańsza od gazety, ale przynosi jednego nowego potencjalnego klienta. 

9. Niektórych klientów interesują samochody osobowe a innych dostawcze. Każdy klient posiada określoną ilość gotówki, dwie marki pojazdów, które go interesują, niewielka grupa akceptuje zakup uszkodzonego pojazdu, część zgodzi się na niesprawne zawieszenie, ale większość z nich kupi tylko w pełni sprawne auto. Możesz przygotować wcześniej większą listę potencjalnych klientów lub napisać generator.

10. Opcje dostępne dla użytkownika:
- przeglądaj bazę samochodów do kupienia 
- kup samochód
- przeglądaj bazę posiadanych samochodów
- napraw samochód
- przejrzyj potencjalnych klientów
- sprzedaj samochód za określoną cenę potencjalnemu klientowi
- kup reklamę
- sprawdź stan konta
- sprawdź historię transakcji
- sprawdź historię napraw każdego pojazdu
- sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych pojazdów
- 
11. Cel gry
Podwoić stan konta w jak najmniejszej liczbie ruchów. Jeden ruch to zakup auta/sprzedaż auta/naprawienie jednego elementu/dodanie jednej reklamy. Przeglądanie stanu konta, historii transakcji, baz klientów, posiadanych pojazdów i pojazdów dostępnych do kupienia nie oznacza wykorzystania ruchu.
