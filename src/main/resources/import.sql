-- userzy
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(1, 'admin@admin.pl', 'admin', 'admin', 'Nowa 21', '923423499', 'admin', 'qwerty', 4);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(2, 'a@l.pl', 'Krysia', 'Krysia', 'Nowa 21', '123423435', 'krysia', 'krysia', 5);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(3, 'a@l.pl', 'Pan', 'Urzednik', 'Nowa 21', '34543', 'urzednik', 'urzednik', 2);

-- userzy zdajacy
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(4, 'pkk@login.pl', 'Jan', 'Nowak', 'Nowa 21', '213213', 'pkk', 'pkk', 3);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(5, 'pkk@login.pl', 'Pawel', 'Pawlowski', 'Nowa 21', '23432', 'pkk2', 'pkk2', 3);


-- userzy egzaminatorzy praktyczni
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(6, 'adres@gmail.com', 'Pawel', 'Nowak', 'Nowa 21', '934', 'practical', 'practical', 0);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(7, 'adres2@gmail.com', 'Daniel', 'Danielski', 'Nowa 21', '684', 'daniel', 'daniel', 0);

-- userzy egzaminatorzy teoretyczni
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(8, 'a@l.pl', 'Adam', 'Nowak', 'Nowa 21', '999', 'teoretical', 'teoretical', 1);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PESEL, LOGIN, PASSWORD, ROLE) VALUES(9, 'a@l.pl', 'Tomek', 'Nowak', 'Nowa 21', '399', 'teoretical2', 'teoretical2', 1);

-- pojazdy (koniecznie po egzaminnie praktycznym, koniecnie id po kolei)
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(1,'VW','czarny', 'Passat', 'TKI-7312', 1.8, 0, 2.0);
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(2,'VW','bialy', 'Passat', 'TKI-1234', 1.8, 0, 2.0);
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(3,'Motocykl','rozowy', 'Jakis', 'TST-2823A2', 1.8, 1, 0.4);


-- egzaminy praktyczne(koniecznie po userach i pojazdach)
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID, PKK_ID) values(1,'2018-02-01 16:00', 0, 12345678910, 6, 1, 4);
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID, PKK_ID) values(2,'2018-02-21 12:00', 0, 11234563421, 6, 3, 4);
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID, PKK_ID) values(3,'2018-02-11 16:30', 0, 38482874823, 7, 3, 5); -- ten egzamin jest do egzaminatora o id=7 jak sie na niego zalogujemy to tylko ten egz sie pokaze
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID, PKK_ID) values(4,'2018-02-11 16:00', 0, 38482874823, 7, 3, 5); -- ten egzamin jest do egzaminatora o id=7 jak sie na niego zalogujemy to tylko ten egz sie pokaze
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID, PKK_ID) values(5,'2018-02-21 12:00', 2, 38482874823, 6, 3, 5); -- ten egzamin jest do egzaminatora o id=7 jak sie na niego zalogujemy to tylko ten egz sie pokaze



-- egzaminy teoretyczne (koniecznie po userach)
INSERT INTO word.WORD_TEORETICAL_EXAM(ID, DATE, ROOM, TEORETICAL_EXAM_STATUS, EXAMINER_ID) VALUES (1, '2018-01-01 00:00:00', '12', 2, 8);
INSERT INTO word.WORD_TEORETICAL_EXAM(ID, DATE, ROOM, TEORETICAL_EXAM_STATUS, EXAMINER_ID) VALUES (2, '2018-01-21 00:00:00', '12', 0, 8);
INSERT INTO word.WORD_TEORETICAL_EXAM(ID, DATE, ROOM, TEORETICAL_EXAM_STATUS, EXAMINER_ID) VALUES (3, '2018-02-10 16:00:00', '12', 1, 9);
INSERT INTO word.WORD_TEORETICAL_EXAM(ID, DATE, ROOM, TEORETICAL_EXAM_STATUS, EXAMINER_ID) VALUES (4, '2018-01-21 00:00:00', '12', 2, 8);

-- teoreticalExamToPKK (koniecznie po userach i egz teoretycznych) PERC_RESULT nie moze byc rowne NULL, gdy nie ma wyniku dajemy -1
INSERT INTO word.WORD_TEORETICAL_EXAM_TO_PKK (ID, TEORETICAL_EXAM_ID, USER_ID, PERC_RESULT, TEXT_RESULT) VALUES ('1', '1', '4', -1, 'brak');
INSERT INTO word.WORD_TEORETICAL_EXAM_TO_PKK (ID, TEORETICAL_EXAM_ID, USER_ID, PERC_RESULT, TEXT_RESULT) VALUES ('2', '1', '5', -1, 'brak');
INSERT INTO word.WORD_TEORETICAL_EXAM_TO_PKK (ID, TEORETICAL_EXAM_ID, USER_ID, PERC_RESULT, TEXT_RESULT) VALUES ('3', '3', '5', 89, 'brak');
INSERT INTO word.WORD_TEORETICAL_EXAM_TO_PKK (ID, TEORETICAL_EXAM_ID, USER_ID, PERC_RESULT, TEXT_RESULT) VALUES ('4 ', '2', '4', 21, 'brak');


-- wnioski o prawko
INSERT INTO word.WORD_APPLICATION (ID, NAME, SURNAME, ADDRESS, PESEL, CATEGORY, STATUS, USER_ID) VALUES(1, 'Jan', 'Nowak', 'Nowa 21', '123', 'B', 1, 4);
INSERT INTO word.WORD_APPLICATION (ID, NAME, SURNAME, ADDRESS, PESEL, CATEGORY, STATUS, USER_ID) VALUES(2, 'Jan', 'Nowak', 'Nowa 21', '123', 'C', 2, 4);
INSERT INTO word.WORD_APPLICATION (ID, NAME, SURNAME, ADDRESS, PESEL, CATEGORY, STATUS, USER_ID) VALUES(3, 'Pawel', 'Pawlowski', 'Stara 21', '123', 'B', 3, 5);


-- pytania teoria
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(1,'Jak długo należy ręcznie stabilizować głowę poszkodowanego z podejrzeniem urazu kręgosłupa szyjnego?','Do przejęcia stabilizacji przez członka zespołu ratownictwa medycznego','Aż zacznie nią poruszać','Do przejęcia stabilizacji przez członka zespołu ratownictwa medycznego','Do czasu stwierdzenia ruchomości jego nóg');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(2,'Na czym polega właściwe telefoniczne wezwanie pomocy do wypadku drogowego? ','Na upewnieniu się, że operator przyjął całą informację o wypadku','Na poinformowaniu operatora jedynie o miejscu wypadku','Na upewnieniu się, że operator przyjął całą informację o wypadku','Na poinformowaniu operatora jedynie o rodzaju zdarzenia oraz liczbie poszkodowanych osób');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(3,'Jesteś świadkiem potrącenia pieszego. Jak powinieneś się zachować? ','Zatrzymać się, wezwać pomoc medyczną i udzielić pierwszej pomocy poszkodowanemu','Nie podejmować działań, gdyż pomocy musi udzielić sprawca wypadku','Wezwać pomoc drogową','Zatrzymać się, wezwać pomoc medyczną i udzielić pierwszej pomocy poszkodowanemu');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(4,'Która z wymienionych czynności może zwiększyć bezpieczeństwo podczas jazdy po zaśnieżonej drodze? ','Stosowanie opon zimowych','Hamowanie wyłącznie przy użyciu hamulca ręcznego','Stosowanie opon zimowych','Zdecydowane przyspieszenie');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(5,'Jaki minimalny odstęp od pojazdu poprzedzającego powinieneś zachować, stojąc w tunelu, w zatorze drogowym tzw korku? ','5 m','3 m','5 m','7 m');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(6,'W jakich warunkach droga hamowania jest najdłuższa','Na drodze oblodzonej','Na drodze suchej','Na drodze mokrej','Na drodze oblodzonej');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(7,'Jaki może być skutek zbyt słabego nacisku na pedał hamulca w samochodzie osobowym? ','Wydłużenie drogi hamowania','Wydłużenie drogi hamowania','Zablokowanie kół','Utrata sterowności');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(8,'Który z wymienionych czynników może powodować ograniczenie pola widzenia kierującego samochodem osobowym? ','Zbyt nisko lub zbyt wysoko ustawiony fotel kierującego','Zbyt nisko lub zbyt wysoko ustawiony fotel kierującego','15 minut odpoczynku po dwugodzinnej jeździe','Okulary przeciwsłoneczne używane w słoneczny dzień');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(9,'Jaki jest cel stosowania systemu ABS w samochodzie osobowym? ','Zapobieganie utracie stabilności i zapewnienie kierowalności pojazdu podczas jego hamowania','Zapobieganie utracie stabilności i zapewnienie kierowalności pojazdu podczas jego hamowania','Zapobieganie przed wpadnięciem pojazdu w poślizg - niezależnie od jego prędkości i warunków na drodze','Ułatwianie pokonywania zakrętów');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(10,'Jaka jest dopuszczalna minimalna głębokość bieżnika w oponie niewyposażonej we wskaźnik granicznego jej zużycia? ','1,6 milimetra','1,6 milimetra','2,6 milimetra','3 milimetry');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(11,'Która z wymienionych okoliczności może świadczyć o złym stanie technicznym samochodu osobowego? ','Pozostawione na miejscu parkowania ślady wycieków płynów eksploatacyjnych','Emisja bezbarwnych spalin','Pozostawione na miejscu parkowania ślady wycieków płynów eksploatacyjnych','Zaświecenie się na czerwono lampki kontrolnej ładowania akumulatora przed uruchomieniem silnika');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(12,'Jaki jest cel stosowania układu ESP w samochodzie osobowym? ','Stabilizowanie ruchu pojazdu podczas jazdy po łuku drogi','Przeciwdziałanie poślizgowi kół podczas hamowania silnikiem','Zapobieganie blokowaniu kół hamowanych','Stabilizowanie ruchu pojazdu podczas jazdy po łuku drogi');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(13,'Jaki jest cel stosowania układu ASR w samochodzie osobowym? ','Przeciwdziałanie poślizgowi kół podczas ruszania','Przeciwdziałanie poślizgowi podczas hamowania silnikiem','Zapobieganie blokowaniu kół hamowanych','Przeciwdziałanie poślizgowi kół podczas ruszania');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(14,'Który z wymienionych czynników może ograniczyć pole widzenia kierującego samochodem osobowym podczas jazdy nocą? ','Niewłaściwie ustawione światła','Zmniejszona prędkość','Uszkodzony system ABS','Niewłaściwie ustawione światła');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3)values(15,'Kiedy należy sprawdzać poziom oleju w silniku? ','Przed uruchomieniem zimnego silnika albo co najmniej po kilku minutach po jego wyłączeniu','Przy uruchomionym silniku','Natychmiast po unieruchomieniu silnika','Przed uruchomieniem zimnego silnika albo co najmniej po kilku minutach po jego wyłączeniu');

