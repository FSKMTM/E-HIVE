INSERT INTO tip (koda) VALUES ('TEMP1');
INSERT INTO tip (koda) VALUES ('TEMP2');
INSERT INTO tip (koda) VALUES ('VLA1');
INSERT INTO tip (koda) VALUES ('VLA2');
INSERT INTO tip (koda) VALUES ('VAROA');

INSERT INTO podnica (naziv) VALUES ('Dominikova podnica');

INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica_id) VALUES (25.8, 'TEMP1', '2015-08-07 05:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica_id) VALUES (24.8, 'TEMP2', '2015-08-07 06:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica_id) VALUES (80, 'VLA1', '2015-08-07 07:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica_id) VALUES (70, 'VLA2', '2015-08-07 08:00:01', 1);
