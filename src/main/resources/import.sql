--userzy
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(1, 'admin@admin.pl', 'admin', 'admin', 'admin', 'qwerty', 4);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(2, 'pkk@login.pl', 'Jan', 'Nowak', 'pkk', 'pkk', 3);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(4, 'a@l.pl', 'Adam', 'Nowak', 'teoretical', 'teoretical', 1);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(5, 'a@l.pl', 'Krysia', 'Krysia', 'kasjerka', 'kasjerka', 5);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(6, 'a@l.pl', 'Pan', 'Urzednik', 'urzednik', 'urzenik', 2);

--userzy egzaminatorzy praktyczni
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(3, 'a@l.pl', 'Pawel', 'Nowak', 'practical', 'practical', 0);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(7, 'b@l.pl', 'Daniel', 'danielski', 'daniel', 'daniel', 0);


--wnioski o prawko
INSERT INTO word.WORD_APPLICATION (ID, NAME, SURNAME, ADDRESS, PESEL, CATEGORY, STATUS, USER_ID) VALUES(1,'Adam','Nowak', 'Nowa 21', '12345678910', 'B', 2, 2);

--pytania teoria
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(1,'Na jakim świetle przejeżdżamy?','Na zielonym','Na czerwonym','Na żółtym','Na zielonym','Jak nikt nie przechodzi to co kogo to obchodzi');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(2,'Co oznacza biały trójkąt z ludzikiem na niebieskim tle?','Przejście dla pieszych','Przejście dla pieszych','Bitelsi','Tędy do monopolowca','Uwaga! Kosmici!');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(3,'Co oznacza znak z biegnącym jeleniem?','Uwaga na dzikie zwierzęta!','Uwaga! Zdradzani mężowie','Uwaga na dzikie zwierzęta','Strefa Rogasia z Doliny Roztoki','Święty Mikołaj zgubił renifera');

--pojazdy (koniecznie przed egzaminem praktycznym)
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(1,'VW','czarny', 'Passat', 'TKI-7312', 1.8, 0, 2.0);
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(2,'VW','bialy', 'Passat', 'TKI-1234', 1.8, 0, 2.0);
INSERT INTO word_machines(id,brand,colour,model,plate,power,type,weight) VALUES(3,'VW','rozowy', 'Passat', 'TST-28A2', 1.8, 0, 2.0);

--egzaminy praktyczne
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID) values(1,'2018-02-01 16:00', 0, 12345678910, 3, 1);
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID) values(2,'2018-02-21 12:00', 0, 11234563421, 3, 3);
insert into word.WORD_PRACTIC_EXAM(ID, DATE, EXAM_RESULT, PESEL, EXAMINER_ID, MACHINE_ID) values(3,'2018-02-11 16:30', 1, 38482874823, 3, 3);


