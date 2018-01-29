INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(1, 'admin@admin.pl', 'admin', 'admin', 'admin', 'qwerty', 4);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(2, 'pkk@login.pl', 'Jan', 'Pawel', 'pkk', 'pkk', 3);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(3, 'a@l.pl', 'Pawel', 'Jan', 'practical', 'examiner', 0);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(4, 'a@l.pl', 'Adam', 'Nowak', 'teoretical', 'examminer', 1);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(5, 'a@l.pl', 'Krysia', 'Krysia', 'pani', 'krysia', 5);
INSERT INTO word.WORD_USER (ID, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES(6, 'a@l.pl', 'Pan', 'Urzednik', 'urzednik', 'miasta', 2);


INSERT INTO word.WORD_APPLICATION (ID, NAME, SURNAME, ADDRESS, PESEL, CATEGORY, STATUS, USER_ID) VALUES(1,'Adam','Nowak', 'Jana Pawla2', '12345678910', 'B', 2, 2);

insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(1,'Na jakim świetle przejeżdżamy?','Na zielonym','Na czerwonym','Na żółtym','Na zielonym','Jak nikt nie przechodzi to co kogo to obchodzi');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(2,'Co oznacza biały trójkąt z ludzikiem na niebieskim tle?','Przejście dla pieszych','Przejście dla pieszych','Bitelsi','Tędy do monopolowca','Uwaga! Kosmici!');
insert into word.WORD_QUESTIONS(ID, CONTENTS, CORRECT_ANSWER, POSSIBLE_ANSWER1, POSSIBLE_ANSWER2, POSSIBLE_ANSWER3,POSSIBLE_ANSWER4)values(3,'Co oznacza znak z biegnącym jeleniem?','Uwaga na dzikie zwierzęta!','Uwaga! Zdradzani mężowie','Uwaga na dzikie zwierzęta','Strefa Rogasia z Doliny Roztoki','Święty Mikołaj zgubił renifera');